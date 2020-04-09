package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.SuggestedBounds

data class VenueQueryResponse(
    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("headerFullLocation")
    val headerFullLocation: String,
    @SerializedName("headerLocation")
    val headerLocation: String,
    @SerializedName("headerLocationGranularity")
    val headerLocationGranularity: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("suggestedBounds")
    val suggestedBounds: SuggestedBounds,
    @SerializedName("suggestedFilters")
    val suggestedFilters: SuggestedFilters,
    @SerializedName("suggestedRadius")
    val suggestedRadius: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)