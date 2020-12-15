package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.datamodels.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JiolocalSearchSuggestionItemBinding
import com.sarthak.jiolocal.viewholders.JioLocalSearchSuggestionViewHolder

class JioLocalSearchSuggestionsAdapter(
        private val jioLocalSearchSuggestions: List<JioLocalSearchSuggestionDao>,
        private val searchSuggestionClickListener: JioLocalSearchSuggestionViewHolder.OnSearchSuggestionClickListener)
    : RecyclerView.Adapter<JioLocalSearchSuggestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JioLocalSearchSuggestionViewHolder {
        val binding: JiolocalSearchSuggestionItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.jiolocal_search_suggestion_item, parent, false
        )
        return JioLocalSearchSuggestionViewHolder(binding, searchSuggestionClickListener)
    }

    override fun onBindViewHolder(holder: JioLocalSearchSuggestionViewHolder, position: Int) {
        holder.bind(jioLocalSearchSuggestions[position])
    }

    override fun getItemCount(): Int = jioLocalSearchSuggestions.size

}