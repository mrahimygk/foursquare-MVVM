package ir.mrahimy.cafebazaar.network.interceptor

import com.google.gson.Gson
import ir.mrahimy.cafebazaar.ktx.serialization.extractResponse
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody


class FoursquareApiInterceptor(
    val version: String,
    private val gson: Gson
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        val url: HttpUrl = request.url().newBuilder()
            .addQueryParameter(
                "client_id",
                "0RC3M3SBMKAQWRKQEUKRXT0C4UE5L2N0JD3V4C45DYS0APUT"
            ).addQueryParameter(
                "client_secret",
                "NR5VX04CU0O1KGAEUG4I3DKJXS5V0YCUZACZ2MS1ULM4CO3E"
            ).addQueryParameter(
                "v",
                version
            )
            .build()
        request = request.newBuilder().url(url).build()
        val response = chain.proceed(request)
        val data = response.body()?.string()?.let { body ->
            gson.extractResponse(body)
        } ?: ""

        val contentType = response.body()?.contentType()
        val newBody = ResponseBody.create(contentType, data)
        return response.newBuilder().body(newBody).build()
    }

}