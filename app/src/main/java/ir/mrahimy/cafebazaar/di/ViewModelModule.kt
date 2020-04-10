package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.ui.details.DetailsViewModel
import ir.mrahimy.cafebazaar.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}