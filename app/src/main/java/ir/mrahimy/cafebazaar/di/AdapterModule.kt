package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.ui.main.MockAdapter
import ir.mrahimy.cafebazaar.ui.main.VenuesAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { MockAdapter() }
    factory { VenuesAdapter() }
}