package ir.mrahimy.cafebazaar.base

import androidx.room.*

/**
 * A base interface to be used in entity data manipulation
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg args: T): List<Long>

    @Delete
    fun delete(arg: T): Int

    @Update
    fun update(arg: T)
}