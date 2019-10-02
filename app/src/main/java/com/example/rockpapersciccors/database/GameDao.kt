package com.example.rockpapersciccors.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rockpapersciccors.models.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    suspend fun getAllGames(): List<Game>

    @Query("SELECT count(g.winner) FROM game g where g.winner = 1")
    suspend fun getWins(): Int

    @Query("SELECT count(g.winner) FROM game g where g.winner = 2")
    suspend fun getLosses(): Int

    @Query("SELECT count(g.winner) FROM game g where g.winner = -1")
    suspend fun getDraws(): Int

    @Insert
    suspend fun insertProduct(product: Game)

    @Delete
    suspend fun deleteProduct(product: Game)

    @Query("DELETE FROM game")
    suspend fun deleteAllProducts()
}