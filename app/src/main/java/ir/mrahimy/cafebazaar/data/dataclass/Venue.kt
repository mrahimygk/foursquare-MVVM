package ir.mrahimy.cafebazaar.data.dataclass


import androidx.room.*
import com.google.gson.annotations.SerializedName
import ir.mrahimy.cafebazaar.network.reponse.Photos
import ir.mrahimy.cafebazaar.network.reponse.VenuePage

@Entity
data class Venue(
    @SerializedName("categories")
    val categories: List<VenueCategory>?,
    @Embedded(prefix = "delivery_")
    @SerializedName("delivery")
    val delivery: Delivery?,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @Embedded(prefix = "location_")
    @SerializedName("location")
    val location: Location?,
    @SerializedName("name")
    val name: String?,
    @Embedded(prefix = "photo_")
    @SerializedName("photos")
    val photos: Photos?,
    @Embedded(prefix = "page_")
    @SerializedName("venuePage")
    val venuePage: VenuePage?,
    /**
     * the most basic way of syncing local order with server when no data has been specified
     * maybe 4sq api orders them by distance ( sqrt(power(lat,2) + power(lon,2) )
     */
    @ColumnInfo(name = "fetched_order")
    val fetchedOrder: Int
) {
    @Ignore
    var image: String? = ""
    @Ignore
    var fullAddress: String? = ""
    @Ignore
    var placeCategories: String? = ""
    @Ignore
    var categoryIcon: String? = ""
    @Ignore
    var websiteIsNull: Boolean = false
}

fun Venue.fill(): Venue {
    delivery?.provider?.icon?.let { address ->
        image = StringBuilder()
            .append(address.prefix)
            .append(address.sizes?.max())
            .append(address.name).toString()
    }

    location?.formattedAddress?.let { address ->
        fullAddress = address.joinToString(" ")
    } ?: location?.address

    placeCategories = categories?.map { it.name }?.joinToString(", ")
    categoryIcon = categories?.filter { it.primary == true }?.firstOrNull()?.icon?.let { icon ->
        "${icon.prefix}${icon.suffix}"
    }
    websiteIsNull = delivery?.url?.isBlank() == true
    return this
}