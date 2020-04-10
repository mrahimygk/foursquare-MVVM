package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.network.api.VenuesApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val apiModule = module {
    factory<VenuesApi> { get<Retrofit>(RetrofitQualifier).create() }
}