package ir.mrahimy.cafebazaar.data.dataclass


import com.google.gson.annotations.SerializedName

data class VenueCategory(
    @SerializedName("icon")
    val icon: SuffixedIconAddress,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pluralName")
    val pluralName: String,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("shortName")
    val shortName: String
)