package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.SearchSuggestionDao
import com.sarthak.jiolocal.databinding.SearchSuggestionItemBinding
import com.sarthak.jiolocal.viewholders.SearchSuggestionViewHolder

class SearchSuggestionsAdapter(private val searchSuggestions : List<SearchSuggestionDao>) : RecyclerView.Adapter<SearchSuggestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSuggestionViewHolder {
        val binding : SearchSuggestionItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.search_suggestion_item, parent, false
        )
        return SearchSuggestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchSuggestionViewHolder, position: Int) {
        holder.bind(searchSuggestions[position])
    }

    override fun getItemCount(): Int = searchSuggestions.size

}