package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName

/**
 * holds the searched venue group type, e.g. recommended places.
 */
data class Group(
    @SerializedName("items")
    val items: List<VenueItem>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?
)