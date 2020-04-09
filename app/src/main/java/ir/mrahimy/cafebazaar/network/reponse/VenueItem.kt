package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.Venue

data class VenueItem(
    @SerializedName("reasons")
    val reasons: Reasons,
    @SerializedName("referralId")
    val referralId: String,
    @SerializedName("venue")
    val venue: Venue
)