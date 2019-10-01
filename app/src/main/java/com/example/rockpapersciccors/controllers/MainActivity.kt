package com.example.rockpapersciccors.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rockpapersciccors.R
import com.example.rockpapersciccors.enums.Choices
import com.example.rockpapersciccors.models.Game
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()
    }

    private fun initButtons() {
        rock_btn.setOnClickListener {
            play(Choices.ROCK)
        }
        paper_btn.setOnClickListener {
            play(Choices.PAPER)
        }
        scissors_btn.setOnClickListener {
            play(Choices.SCISSORS)
        }
    }

    private fun play(userChoice: Choices) {
        val computerChoice: Choices? = getComputerChoice()

        computer_img_choice.setImageResource(computerChoice!!.image)
        user_img_choice.setImageResource(userChoice.image)

        when {
            userChoice.defeats == computerChoice.value -> {
                match_result.text = getString(R.string.user_win)
            }
            computerChoice.defeats == userChoice.value -> {
                match_result.text = getString(R.string.computer_win)
            }
            userChoice.value == computerChoice.value -> {
                match_result.text = getString(R.string.draw)
            }
        }
    }

    private fun getComputerChoice(): Choices? {
        when ((1..3).shuffled().first()) {
            Choices.ROCK.value -> return Choices.ROCK
            Choices.PAPER.value -> return Choices.PAPER
            Choices.SCISSORS.value -> return Choices.SCISSORS
        }
        return null
    }
}
