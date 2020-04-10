package ir.mrahimy.cafebazaar

import ir.mrahimy.cafebazaar.data.dataclass.LabeledLatLng
import ir.mrahimy.cafebazaar.data.dataclass.SuffixedIconAddress
import ir.mrahimy.cafebazaar.data.dataclass.VenueCategory
import ir.mrahimy.cafebazaar.db.typeconverter.IntListConverter
import ir.mrahimy.cafebazaar.db.typeconverter.LabeledLatLngListConverter
import ir.mrahimy.cafebazaar.db.typeconverter.StringListConverter
import ir.mrahimy.cafebazaar.db.typeconverter.VenueCategoryListConverter
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

        println(fromList)
        println(backToJson)
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
    fun `compare Serialization Time and direct gson`() {
        val gsonTime = measureTimeMillis {
            convertingWithGson()
        }

        val serializerTime = measureTimeMillis {
            convertingWithSerialization()
        }

        println(serializerTime)
        println(gsonTime)
    }

    @Test
    fun `test converting string list to json and getting it back`() {
        val list = listOf(
            "Ali",
            "Dali",
            "Naghi",
            "Mashti",
            "Juju"
        )

        val slc = StringListConverter()
        val jsonFromList = slc.fromList(list)
        val listFromJson = slc.fromDb(jsonFromList)
        val jsonFromDbList = slc.fromList(listFromJson)

        println(list)
        println(listFromJson)
        println(jsonFromList)
        println(jsonFromDbList)

        assert(list == listFromJson)
        assert(jsonFromDbList == jsonFromList)

    }

    @Test
    fun `test converting venue category list to json and getting it back`() {
        val list = listOf(
            VenueCategory(
                SuffixedIconAddress("a", ".png"),
                "1",
                "name1",
                "names1",
                true,
                "shortname1"
            ),
            VenueCategory(
                SuffixedIconAddress("b", ".jpg"),
                "2",
                "name2",
                "names2",
                true,
                "shortname2"
            ),
            VenueCategory(
                SuffixedIconAddress("c", ".gif"),
                "3",
                "name3",
                "names3",
                true,
                "shortname3"
            )
        )

        val vclc = VenueCategoryListConverter()
        val jsonFromList = vclc.fromList(list)
        val listFromJson = vclc.fromDb(jsonFromList)
        val jsonFromDbList = vclc.fromList(listFromJson)

        println(list)
        println(listFromJson)
        println(jsonFromList)
        println(jsonFromDbList)
    }
}
