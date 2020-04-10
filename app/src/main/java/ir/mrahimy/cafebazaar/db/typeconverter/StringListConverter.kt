package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory
import java.io.Serializable

class StringListConverter : Serializable {

    @TypeConverter
    fun fromList(list: List<String>?) = toJson(list)

    @TypeConverter
    fun fromDb(json: String): List<String> = fromJson(json)

}