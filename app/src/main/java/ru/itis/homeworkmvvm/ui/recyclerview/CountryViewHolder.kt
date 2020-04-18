package ru.itis.homeworkmvvm.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import ru.itis.homeworkmvvm.data.model.Country
import ru.itis.homeworkmvvm.databinding.ItemCountryBinding

class CountryViewHolder (private val itemCountryBinding: ItemCountryBinding)
    : RecyclerView.ViewHolder(itemCountryBinding.root) {

    fun bind(item: Country, clickListener: (String) -> Unit) {
        itemCountryBinding.country = item
        itemCountryBinding.root.setOnClickListener { clickListener(item.country) }
        itemCountryBinding.executePendingBindings()
    }
}
