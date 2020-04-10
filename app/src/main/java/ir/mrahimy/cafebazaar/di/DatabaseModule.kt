package ir.mrahimy.cafebazaar.di

import androidx.room.Room
import ir.mrahimy.cafebazaar.db.FourSquareDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            FourSquareDb::class.java,
            "foursquare"
        ).fallbackToDestructiveMigration()
            .build()
    }

    factory {
        get<FourSquareDb>().venueDao()
    }
}