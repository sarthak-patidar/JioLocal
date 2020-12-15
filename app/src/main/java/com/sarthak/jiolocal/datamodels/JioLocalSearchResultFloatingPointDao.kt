package com.sarthak.jiolocal.datamodels

//import com.bumptech.glide.Glide

class JioLocalSearchResultFloatingPointDao(
        val floatingPointId: String,
        val floatingPointTitle: String,
        val floatingPointDistance: Int,
        val floatingPointImageUrl: String,
        val floatingPointAddress: String,
        val floatingPointLatitude: Double,
        val floatingPointLongitude: Double,
        val isFloatingPointOpen: Boolean,
        val floatingPointRatings: Float,
        val floatingPointRatingsCount: Int,
        val floatingPointOfferCount: Int,
        val isOnlineBookingAvailable: Boolean,
        val floatingPointContactNumber: Long
) {

    val floatingPointOfferString = "$floatingPointOfferCount Offers"
    val floatingPointRatingsString = "$floatingPointRatings"
    val floatingPointDistanceString = "$floatingPointDistance M"
    val floatingPointRatingsCountString = "$floatingPointRatingsCount ratings"
    val floatingPointOpenCloseText = when (isFloatingPointOpen) {
        true -> "OPEN NOW"
        else -> "CLOSED"
    }
    val floatingPointTruncatedAddress = floatingPointAddress.take(28) + "..."

//    @BindingAdapter("android:image")
//    fun insertImage(view: View, url: String) {
//        Glide.with(view).load(url).into(view as ImageView)
//    }
}