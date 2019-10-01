package com.example.rockpapersciccors.models

import java.util.*

data class Game(
    var userImage: Int,
    var computerImage: Int,
    var winner: String,
    var date: Date,
    val pcName: String,
    val userName: String,
    var id: Long? = null
)