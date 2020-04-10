package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.network.BaseUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object LoggingInterceptorQualifier : Qualifier
object OkHttpQualifier : Qualifier
object RetrofitQualifier : Qualifier

val networkModule = module {


    factory<Interceptor>(LoggingInterceptorQualifier) {
        HttpLoggingInterceptor { log ->
            Timber.d(log)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<OkHttpClient>(OkHttpQualifier) {
        OkHttpClient.Builder().apply {
            addInterceptor(get(LoggingInterceptorQualifier))
            cache(get())
        }.build()
    }

    single<Retrofit>(RetrofitQualifier) {
        Retrofit.Builder()
            .baseUrl(BaseUrl.BASE_URL)
            .client(get(OkHttpQualifier))
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
}