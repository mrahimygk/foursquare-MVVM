package ir.mrahimy.cafebazaar.base

import androidx.room.*

/**
 * A base interface to be used in entity data manipulation
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg args: T)

    @Delete
    suspend fun delete(arg: T): Int

    @Update
    suspend fun update(arg: T)
}