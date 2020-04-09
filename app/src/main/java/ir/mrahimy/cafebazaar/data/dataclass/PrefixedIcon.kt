package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class PrefixedIcon(
    @SerializedName("name")
    val name: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("sizes")
    val sizes: List<Int>
)