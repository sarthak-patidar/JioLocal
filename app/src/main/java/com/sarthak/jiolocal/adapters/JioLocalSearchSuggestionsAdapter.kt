package com.sarthak.jiolocal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JioLocalSearchSuggestionItemBinding
import com.sarthak.jiolocal.viewholders.JioLocalSearchSuggestionViewHolder

class JioLocalSearchSuggestionsAdapter(private val jioLocalSearchSuggestions : List<JioLocalSearchSuggestionDao>) : RecyclerView.Adapter<JioLocalSearchSuggestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JioLocalSearchSuggestionViewHolder {
        val binding : JioLocalSearchSuggestionItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.jio_local_search_suggestion_item, parent, false
        )
        return JioLocalSearchSuggestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JioLocalSearchSuggestionViewHolder, position: Int) {
        holder.bind(jioLocalSearchSuggestions[position])
    }

    override fun getItemCount(): Int = jioLocalSearchSuggestions.size

}