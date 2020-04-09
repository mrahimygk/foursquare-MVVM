package ir.mrahimy.cafebazaar.application

import android.app.Application
import ir.mrahimy.cafebazaar.di.adapterModule
import ir.mrahimy.cafebazaar.di.modelModule
import ir.mrahimy.cafebazaar.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FourSquareApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FourSquareApplication)
            androidLogger(Level.DEBUG)
            modules(adapterModule,
                 modelModule, viewModelModule)
        }
    }
}