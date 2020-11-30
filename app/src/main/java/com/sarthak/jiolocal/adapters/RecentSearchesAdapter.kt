package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.RecentSearchDao
import com.sarthak.jiolocal.databinding.RecentSearchItemBinding
import com.sarthak.jiolocal.viewholders.RecentSearchesViewHolder

class RecentSearchesAdapter(private val recentSearches : List<RecentSearchDao>) : RecyclerView.Adapter<RecentSearchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentSearchesViewHolder {
        val binding : RecentSearchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recent_search_item, parent,false)
        return RecentSearchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentSearchesViewHolder, position: Int) {
        holder.bind(recentSearches[position])
    }

    override fun getItemCount(): Int = recentSearches.size
}