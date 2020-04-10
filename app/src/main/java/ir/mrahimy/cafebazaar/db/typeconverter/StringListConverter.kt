package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import ir.mrahimy.cafebazaar.ktx.serialization.fromJson
import ir.mrahimy.cafebazaar.ktx.serialization.toJson
import java.io.Serializable

class StringListConverter : Serializable {

    @TypeConverter
    fun fromList(list: List<String>?) = toJson(list)

    @TypeConverter
    fun fromDb(json: String?): List<String> = fromJson(json)

}