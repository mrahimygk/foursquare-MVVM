package ir.mrahimy.cafebazaar.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module

val serializationModule = module {

    factory {
        GsonBuilder()
            .disableHtmlEscaping()
            .create()
    }

}