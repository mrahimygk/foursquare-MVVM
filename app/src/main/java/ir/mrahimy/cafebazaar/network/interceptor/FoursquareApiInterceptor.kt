package ir.mrahimy.cafebazaar.network.interceptor

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class FoursquareApiInterceptor(val version: String = "20200101") : Interceptor {

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
        return chain.proceed(request)
    }

}