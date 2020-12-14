package com.sarthak.jiolocal.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.databinding.JiolocalSearchResultsFloatingPointItemBinding
import com.sarthak.jiolocal.dao.JioLocalSearchResultFloatingPointDao

class JioLocalSearchResultsFloatingPointItemViewHolder(
        private val itemBinding: JiolocalSearchResultsFloatingPointItemBinding,
        private val searchResultFloatingPointItemClickListener: OnSearchResultFloatingPointItemClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {

    private val context = itemBinding.root.context

    fun bind(data: JioLocalSearchResultFloatingPointDao) {
        itemBinding.floatingPoint = data

        // TODO: 10-12-2020 : verify this logic to toggle call button visibility
        itemBinding.serviceItemCallButton.visibility = when (data.isFloatingPointOpen) {
            true -> View.VISIBLE
            else -> View.GONE
        }

        if (data.isOnlineBookingAvailable) {
            itemBinding.serviceItemBookAppointmentButton.visibility = View.VISIBLE
            itemBinding.serviceItemCallButton.background = ContextCompat.getDrawable(context, R.drawable.bordered_blue_bg)
            itemBinding.serviceItemCallButtonText.setTextColor(ContextCompat.getColor(context, R.color.jiolocal_blue))
            itemBinding.serviceItemCallButtonIcon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.jiolocal_blue)
        } else {
            itemBinding.serviceItemBookAppointmentButton.visibility = View.GONE
            itemBinding.serviceItemCallButton.background = ContextCompat.getDrawable(context, R.drawable.bg_rounded_corner_4dp_radius)
            itemBinding.serviceItemCallButtonText.setTextColor(ContextCompat.getColor(context, R.color.white))
            itemBinding.serviceItemCallButtonIcon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.white)
        }

        // card title click listener
        itemBinding.serviceItemName.setOnClickListener {
            searchResultFloatingPointItemClickListener.onFloatingPointItemClick(data)
        }

        // book appointment click listener
        itemBinding.serviceItemBookAppointmentButton.setOnClickListener {
            searchResultFloatingPointItemClickListener.onFloatingPointBookAppointmentClick(data)
        }

        // call now button click listener.
        // todo: add if call now option is available.
        itemBinding.serviceItemCallButton.setOnClickListener {
            searchResultFloatingPointItemClickListener.onFloatingPointCallButtonClick(data)
        }
    }

    interface OnSearchResultFloatingPointItemClickListener {
        fun onFloatingPointItemClick(searchResultFloatingPoint : JioLocalSearchResultFloatingPointDao)

        fun onFloatingPointCallButtonClick(searchResultFloatingPoint : JioLocalSearchResultFloatingPointDao)

        fun onFloatingPointBookAppointmentClick(searchResultFloatingPoint : JioLocalSearchResultFloatingPointDao)
    }
}