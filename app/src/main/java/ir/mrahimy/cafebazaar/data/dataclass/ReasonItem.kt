package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class ReasonItem(
    @SerializedName("reasonName")
    val reasonName: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("type")
    val type: String
)