package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class SuggestedBound(
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?
)