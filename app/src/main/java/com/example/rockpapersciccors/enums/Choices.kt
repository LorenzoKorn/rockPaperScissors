package com.example.rockpapersciccors.enums

import com.example.rockpapersciccors.R

enum class Choices(val value: Int, val defeats: Int, val image: Int) {
    ROCK(1, 3, R.drawable.rock),
    PAPER(2, 1, R.drawable.paper),
    SCISSORS(3, 2, R.drawable.scissors)
}