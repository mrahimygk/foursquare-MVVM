package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

class StringListConverter : Serializer() {

    private val type by lazy {
        object : TypeToken<List<String>?>() {}.type
    }

    @TypeConverter
    fun fromList(list: List<String>?) = gson.toJson(list, type)

    @TypeConverter
    fun fromDb(json: String?): List<String>? = gson.fromJson(json, type)

}