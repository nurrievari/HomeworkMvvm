package ru.itis.homeworkmvvm.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.itis.homeworkmvvm.R
import ru.itis.homeworkmvvm.data.model.Country

class CountryAdapter (
    private var list: MutableList<Country>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_country,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    fun update(data: MutableList<Country>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}
