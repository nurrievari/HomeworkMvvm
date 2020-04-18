package ru.itis.homeworkmvvm.ui.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_countries.*
import ru.itis.homeworkmvvm.R

import ru.itis.homeworkmvvm.data.model.Country
import ru.itis.homeworkmvvm.databinding.FragmentCountriesBinding
import ru.itis.homeworkmvvm.di.App
import ru.itis.homeworkmvvm.ui.recyclerview.CountryAdapter
import ru.itis.homeworkmvvm.viewmodel.CountriesViewModel
import javax.inject.Inject

class CountriesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var countriesViewModel: CountriesViewModel
    lateinit var binding: FragmentCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.plusCountriesComponentBuilder().create().inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountriesBinding.inflate(inflater)
        binding.rvCountries.adapter = CountryAdapter(emptyList<Country>().toMutableList(), clickListener)
        countriesViewModel = ViewModelProvider(this, viewModelFactory)
            .get(CountriesViewModel::class.java)
        subscribe()
        binding.viewModel = countriesViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search)?.actionView as SearchView
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
        }
        searchView.setOnQueryTextListener(queryListener)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private val queryListener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(newText: String?): Boolean {
            newText?.let { clickListener(it) }
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    }

    private val clickListener = { country: String ->
        val bundle = Bundle()
        bundle.putString("country", country)
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        val a = activity?.supportFragmentManager.also {
            it?.beginTransaction()?.apply {
                replace(R.id.container, fragment)
                addToBackStack(DetailsFragment::class.java.name)
                commit()
            }
        }
    }

    private fun subscribe() {
        countriesViewModel.countries.observe(viewLifecycleOwner, Observer { items ->
            (rvCountries.adapter as CountryAdapter).update(items.toMutableList())
        })
        countriesViewModel.getCountries()
    }

    override fun onResume() {
        super.onResume()
        countriesViewModel.getCountries()
    }
}
