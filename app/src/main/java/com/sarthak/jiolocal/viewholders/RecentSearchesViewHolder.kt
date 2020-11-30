package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.BR
import com.sarthak.jiolocal.dao.RecentSearchDao
import com.sarthak.jiolocal.databinding.RecentSearchItemBinding

class RecentSearchesViewHolder(private val binding: RecentSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: RecentSearchDao) {
        binding.setVariable(BR.recentSearch, data)
        binding.executePendingBindings()
    }

}