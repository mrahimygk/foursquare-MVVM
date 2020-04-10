package ir.mrahimy.cafebazaar.db.typeconverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

fun <T> Serializable.toJson(list: List<T>?): String {
    val gson = Gson()
    val type = object : TypeToken<List<T?>?>() {}.type
    return gson.toJson(list, type)
}

fun <T> Serializable.fromJson(json: String?): List<T> {
    val gson = Gson()
    val type = object : TypeToken<List<T?>?>() {}.type
    return gson.fromJson(json, type)
}