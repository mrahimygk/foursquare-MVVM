package ir.mrahimy.cafebazaar.di

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import timber.log.Timber

object LoggingInterceptorQualifier : Qualifier

val networkModule = module {


    factory<Interceptor>(LoggingInterceptorQualifier) {
        HttpLoggingInterceptor { log ->
            Timber.d(log)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

}