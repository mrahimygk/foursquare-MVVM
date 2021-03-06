package ir.mrahimy.cafebazaar.application

import android.app.Application
import ir.mrahimy.cafebazaar.BuildConfig
import ir.mrahimy.cafebazaar.di.*
import ir.mrahimy.cafebazaar.network.ConnectionLiveData
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class FourSquareApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@FourSquareApplication)
            androidLogger(Level.DEBUG)
            modules(
                adapterModule,
                modelModule, viewModelModule,
                serializationModule,
                databaseModule,
                networkModule,
                repositoryModule,
                apiModule
            )
        }
        ConnectionLiveData.init(this)
    }
}