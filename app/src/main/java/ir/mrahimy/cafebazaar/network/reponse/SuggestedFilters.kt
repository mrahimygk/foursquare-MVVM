package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.Filter

data class SuggestedFilters(
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("header")
    val header: String
)