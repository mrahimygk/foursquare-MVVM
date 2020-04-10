package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.ui.main.MainModel
import org.koin.dsl.module

val modelModule = module {
    factory { MainModel(get()) }
}