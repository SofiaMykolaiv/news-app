package com.example.news_app.data.database.dao

import androidx.room.*
import com.example.news_app.data.database.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<ArticleEntity>)

    @Delete
    suspend fun delete(obj: ArticleEntity)

    @Query("DELETE FROM TABLE_ARTICLE")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_ARTICLE")
    suspend fun getList(): List<ArticleEntity>
}