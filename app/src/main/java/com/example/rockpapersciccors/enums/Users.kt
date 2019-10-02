package com.example.rockpapersciccors.enums

import com.example.rockpapersciccors.R

enum class Users(var id: Int, var winMessage: Int) {
    USER(1, R.string.user_win),
    COMPUTER(2, R.string.computer_win),
    NONE(-1, R.string.draw)
}