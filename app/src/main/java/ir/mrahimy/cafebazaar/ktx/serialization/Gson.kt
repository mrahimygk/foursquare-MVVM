package ir.mrahimy.cafebazaar.ktx.serialization

import com.google.gson.Gson
import ir.mrahimy.cafebazaar.network.ApiException
import ir.mrahimy.cafebazaar.network.reponse.FourSquareExploreVenuesRes

fun Gson.extractResponse(response: String): String {
    val apiResponse = fromJson(response, FourSquareExploreVenuesRes::class.java)
    if (apiResponse.meta.code == 200) {
        return if (apiResponse.response == null) "{}" else toJson(apiResponse.response)
    } else throw ApiException(apiResponse.meta.code)
}