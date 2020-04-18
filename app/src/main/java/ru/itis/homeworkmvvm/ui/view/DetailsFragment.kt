package ru.itis.homeworkmvvm.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.textView

import ru.itis.homeworkmvvm.R
import ru.itis.homeworkmvvm.data.model.Country
import ru.itis.homeworkmvvm.databinding.FragmentDetailsBinding
import ru.itis.homeworkmvvm.di.App
import ru.itis.homeworkmvvm.viewmodel.DetailsViewModel
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var detailsViewModel: DetailsViewModel
    lateinit var fragmentDetailsBinding: FragmentDetailsBinding
    lateinit var country: String

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.plusDetailsComponentBuilder().create().inject(this)
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getString("country").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDetailsBinding = FragmentDetailsBinding.inflate(inflater)
        fragmentDetailsBinding.lifecycleOwner = viewLifecycleOwner
        detailsViewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailsViewModel::class.java)
        subscribe()
        detailsViewModel.getCountry(country)
        return fragmentDetailsBinding.root
    }

    private fun subscribe() {
        detailsViewModel.country.observe(viewLifecycleOwner, Observer {
            fragmentDetailsBinding.country = it
            activity?.applicationContext?.let { it1 ->
                Glide.with(it1)
                    .load(it.countryInfo.flag)
                    .into(fragmentDetailsBinding.ivFlag)
            }
        })
    }

}
