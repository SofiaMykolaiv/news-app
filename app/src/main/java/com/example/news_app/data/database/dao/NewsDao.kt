package com.example.news_app.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.news_app.data.database.entity.NewsEntity

@Dao
interface NewsDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(obj: NewsEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insert(obj: List<NewsEntity>)

    @Delete
    suspend fun delete(obj: NewsEntity)

    @Query("DELETE FROM TABLE_NEWS")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_NEWS")
    suspend fun getList(): List<NewsEntity>
}