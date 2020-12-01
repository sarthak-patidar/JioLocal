package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.JioLocalRecentSearchDao
import com.sarthak.jiolocal.databinding.JioLocalRecentSearchItemBinding
import com.sarthak.jiolocal.viewholders.JioLocalRecentSearchesViewHolder

class JioLocalRecentSearchesAdapter(private val recentSearches : List<JioLocalRecentSearchDao>) : RecyclerView.Adapter<JioLocalRecentSearchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JioLocalRecentSearchesViewHolder {
        val binding : JioLocalRecentSearchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.jio_local_recent_search_item, parent,false)
        return JioLocalRecentSearchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JioLocalRecentSearchesViewHolder, position: Int) {
        holder.bind(recentSearches[position])
    }

    override fun getItemCount(): Int = recentSearches.size
}