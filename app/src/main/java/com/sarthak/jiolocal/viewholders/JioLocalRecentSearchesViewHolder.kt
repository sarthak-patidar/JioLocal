package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.BR
import com.sarthak.jiolocal.dao.JioLocalRecentSearchDao
import com.sarthak.jiolocal.databinding.JioLocalRecentSearchItemBinding

class JioLocalRecentSearchesViewHolder(private val binding: JioLocalRecentSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: JioLocalRecentSearchDao) {
        binding.setVariable(BR.recentSearch, data)
        binding.executePendingBindings()
    }

}