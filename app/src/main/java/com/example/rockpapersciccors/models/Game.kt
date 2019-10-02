package com.example.rockpapersciccors.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class Game(
    @ColumnInfo(name = "userImage")
    var userImage: Int,

    @ColumnInfo(name = "computeImage")
    var computerImage: Int,

    @ColumnInfo(name = "winner")
    var winner: Int,

    @ColumnInfo(name = "winMessage")
    var winMessage: String,

    @ColumnInfo(name = "date")
    var date: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)