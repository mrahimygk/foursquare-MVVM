package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.data.dataclass.SuggestedBound

data class SuggestedBounds(
    @SerializedName("ne")
    val ne: SuggestedBound,
    @SerializedName("sw")
    val sw: SuggestedBound
)