package ir.mrahimy.cafebazaar.db.typeconverter

import com.google.gson.Gson
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.Serializable

open class Serializer : Serializable, KoinComponent {
    protected val gson: Gson by inject()
}