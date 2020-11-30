package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.SearchResultDao
import com.sarthak.jiolocal.databinding.SearchResultItemBinding
import com.sarthak.jiolocal.viewholders.SearchResultViewHolder

class SearchResultsAdapter(private val searchResults : List<SearchResultDao>) : RecyclerView.Adapter<SearchResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val binding : SearchResultItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.search_result_item, parent, false
        )
        return SearchResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(searchResults[position])
    }

    override fun getItemCount(): Int = searchResults.size

}