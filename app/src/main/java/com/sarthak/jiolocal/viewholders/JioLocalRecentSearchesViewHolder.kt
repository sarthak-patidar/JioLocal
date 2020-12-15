package com.sarthak.jiolocal.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.datamodels.JioLocalRecentSearchDao
import com.sarthak.jiolocal.databinding.JiolocalRecentSearchItemBinding

class JioLocalRecentSearchesViewHolder(private val binding: JiolocalRecentSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: JioLocalRecentSearchDao) {
        binding.recentSearch = data
    }

}