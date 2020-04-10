package ir.mrahimy.cafebazaar.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable


class IntListConverter : Serializable {

    private var gson = Gson()
    @TypeConverter
    fun fromList(list: List<Int>?): String {
        val type = object : TypeToken<List<Int?>?>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun fromDb(json: String?): List<Int> {
        val type = object : TypeToken<List<Int?>?>() {}.type
        return gson.fromJson(json, type)
    }
}