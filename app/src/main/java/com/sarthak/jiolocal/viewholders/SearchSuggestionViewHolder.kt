package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.BR
import com.sarthak.jiolocal.dao.SearchSuggestionDao
import com.sarthak.jiolocal.databinding.SearchSuggestionItemBinding

class SearchSuggestionViewHolder(val binding : SearchSuggestionItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: SearchSuggestionDao) {
        binding.setVariable(BR.searchSuggestion , data)
        binding.executePendingBindings()
    }

}