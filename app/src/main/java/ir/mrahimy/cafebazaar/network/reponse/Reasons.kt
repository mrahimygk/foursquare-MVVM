package ir.mrahimy.cafebazaar.network.reponse


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.ReasonItem

data class Reasons(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("items")
    val items: List<ReasonItem?>?
)