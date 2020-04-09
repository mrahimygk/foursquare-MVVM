package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.ui.main.MainModel
import ir.mrahimy.cafebazaar.ui.main.MockAdapter
import org.koin.dsl.module

val modelModule = module {
    factory { MainModel() }
}