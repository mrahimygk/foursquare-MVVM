package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.LabeledLatLng

data class Location(
    @SerializedName("address")
    val address: String?,
    @SerializedName("cc")
    val cc: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("crossStreet")
    val crossStreet: String?,
    @SerializedName("distance")
    val distance: Int?,
    @SerializedName("formattedAddress")
    val formattedAddress: List<String>?,
    @SerializedName("labeledLatLngs")
    val labeledLatLngList: List<LabeledLatLng?>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?,
    @SerializedName("postalCode")
    val postalCode: String?,
    @SerializedName("state")
    val state: String?
)