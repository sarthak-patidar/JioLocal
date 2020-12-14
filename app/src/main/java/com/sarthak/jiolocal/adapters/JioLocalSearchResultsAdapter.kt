package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.databinding.JiolocalSearchResultsFloatingPointItemBinding
import com.sarthak.jiolocal.viewholders.JioLocalSearchResultsFloatingPointItemViewHolder
import com.sarthak.jiolocal.dao.JioLocalSearchResultFloatingPointDao

class JioLocalSearchResultsAdapter(
        private val searchResultFloatingPoints: List<JioLocalSearchResultFloatingPointDao>,
        private val searchResultFloatingPointFloatingPointItemClickListener: JioLocalSearchResultsFloatingPointItemViewHolder.OnSearchResultFloatingPointItemClickListener
) : RecyclerView.Adapter<JioLocalSearchResultsFloatingPointItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JioLocalSearchResultsFloatingPointItemViewHolder {
        val binding: JiolocalSearchResultsFloatingPointItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.jiolocal_search_results_floating_point_item, parent, false
        )
        return JioLocalSearchResultsFloatingPointItemViewHolder(binding, searchResultFloatingPointFloatingPointItemClickListener)
    }

    override fun onBindViewHolder(holder: JioLocalSearchResultsFloatingPointItemViewHolder, position: Int) {
        holder.bind(searchResultFloatingPoints[position])
    }

    override fun getItemCount(): Int = searchResultFloatingPoints.size

}