package ir.mrahimy.cafebazaar.db.dao

import androidx.room.*

/**
 * A base interface to be used in entity dao CRUD
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(arg:T) :Long

    @Delete
    fun delete(arg: T):Int

    @Update
    fun update(arg: T)
}