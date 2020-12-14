package com.sarthak.jiolocal.viewholders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JiolocalSearchSuggestionItemBinding

class JioLocalSearchSuggestionViewHolder(
    val binding: JiolocalSearchSuggestionItemBinding, private val searchSuggestionClickListener: OnSearchSuggestionClickListener)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: JioLocalSearchSuggestionDao) {
        binding.searchSuggestion = data
        binding.searchSuggestionLayoutRoot.setOnClickListener {
            searchSuggestionClickListener.onSearchSuggestionClick(data)
            Log.i("SearchSuggestionHolder", "onClick method called on ${data.title}")
        }
    }

    interface OnSearchSuggestionClickListener {
        fun onSearchSuggestionClick(item: JioLocalSearchSuggestionDao)
    }
}