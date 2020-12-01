package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.BR
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JioLocalSearchSuggestionItemBinding

class JioLocalSearchSuggestionViewHolder(val binding : JioLocalSearchSuggestionItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: JioLocalSearchSuggestionDao) {
        binding.setVariable(BR.searchSuggestion , data)
        binding.executePendingBindings()
    }
}