package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.BR
import com.sarthak.jiolocal.dao.SearchResultDao
import com.sarthak.jiolocal.databinding.SearchResultItemBinding

class SearchResultViewHolder(val binding : SearchResultItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: SearchResultDao) {
        binding.setVariable(BR.searchResult , data)
        binding.executePendingBindings()
    }

}