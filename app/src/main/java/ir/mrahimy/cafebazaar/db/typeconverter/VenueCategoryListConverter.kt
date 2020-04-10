package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory
import java.io.Serializable

class VenueCategoryListConverter : Serializable {

    @TypeConverter
    fun fromList(list: List<VenueCategory>?) = toJson(list)

    @TypeConverter
    fun fromDb(json: String?): List<VenueCategory> = fromJson(json)
}