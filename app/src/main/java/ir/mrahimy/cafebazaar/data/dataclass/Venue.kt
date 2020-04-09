package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage

data class Venue(
    @SerializedName("categories")
    val categories: List<VenueCategory>,
    @SerializedName("delivery")
    val delivery: Delivery,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("venuePage")
    val venuePage: VenuePage
)