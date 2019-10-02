package com.example.rockpapersciccors.database

import android.content.Context
import com.example.rockpapersciccors.models.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val db = GameRoomDatabase.getDatabase(context)
        gameDao = db!!.gameDao()
    }

    //          name              returns      {logic + return} || = return
    suspend fun getHistory(): List<Game> = gameDao.getAllGames()

    suspend fun getWins(): Int = gameDao.getWins()

    suspend fun getLosses(): Int = gameDao.getLosses()

    suspend fun getDraws(): Int = gameDao.getDraws()

    suspend fun insertGame(game: Game) = gameDao.insertProduct(game)

    suspend fun deleteGame(game: Game) = gameDao.deleteProduct(game)

    suspend fun deleteHistory() = gameDao.deleteAllProducts()
}