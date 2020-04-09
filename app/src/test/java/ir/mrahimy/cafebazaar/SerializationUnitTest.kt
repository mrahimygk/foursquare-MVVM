package ir.mrahimy.cafebazaar

import ir.mrahimy.cafebazaar.data.dataclass.LabeledLatLng
import ir.mrahimy.cafebazaar.db.typeconverter.IntListConverter
import ir.mrahimy.cafebazaar.db.typeconverter.LabeledLatLngListConverter
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SerializationUnitTest {

    @Test
    fun convertingWithGson() {
        val list = listOf(1, 2, 3)
        val ilc = IntListConverter()
        val fromList = ilc.fromList(list)
        val fromDb = ilc.fromDb(fromList)
        val backToJson = ilc.fromList(fromDb)

        assert(fromList == backToJson)
    }

    @Test
    fun convertingWithSerialization() {
        val list = listOf(
            LabeledLatLng("l1", 1.0, 1.0),
            LabeledLatLng("l2", 2.0, 2.0),
            LabeledLatLng("l3", 3.0, 3.0)
        )

        val ilc = LabeledLatLngListConverter()
        val fromList = ilc.fromList(list)
        val fromDb = ilc.fromDb(fromList)
        val backToJson = ilc.fromList(fromDb)

        assert(fromList == backToJson)
    }

    @Test
    fun measureSerializationCompared() {
        val gsonTime = measureTimeMillis {
            convertingWithGson()
        }

        val serializerTime = measureTimeMillis {
            convertingWithSerialization()
        }

        assert(serializerTime < gsonTime)
    }
}
