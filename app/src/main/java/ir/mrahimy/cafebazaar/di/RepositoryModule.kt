package ir.mrahimy.cafebazaar.di

import ir.mrahimy.cafebazaar.repository.VenueRepository
import ir.mrahimy.cafebazaar.repository.VenueRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<VenueRepository> { VenueRepositoryImpl(get(), get()) }
}