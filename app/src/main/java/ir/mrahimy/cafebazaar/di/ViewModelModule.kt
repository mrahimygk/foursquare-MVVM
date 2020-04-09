package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.ui.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel(get()) }
}