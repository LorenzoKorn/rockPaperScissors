package com.example.rockpapersciccors.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.rockpapersciccors.R
import com.example.rockpapersciccors.database.GameRepository
import com.example.rockpapersciccors.enums.Choices
import com.example.rockpapersciccors.enums.Users
import com.example.rockpapersciccors.models.Game
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var gameRepository: GameRepository
    private var mainScope = CoroutineScope(Dispatchers.Main)
    private var wins: Int = 0
    private var losses: Int = 0
    private var draws: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameRepository = GameRepository(this)

        initButtons()
        initScore()
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

    private fun initScore() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                wins = gameRepository.getWins()
                losses = gameRepository.getLosses()
                draws = gameRepository.getDraws()
            }
        }
    }

    private fun play(userChoice: Choices) {
        val computerChoice: Choices? = getComputerChoice()

        computer_img_choice.setImageResource(computerChoice!!.image)
        user_img_choice.setImageResource(userChoice.image)
        lateinit var winner: Users

        when {
            userChoice.defeats == computerChoice.value -> {
                winner = Users.USER
                wins += 1
            }
            computerChoice.defeats == userChoice.value -> {
                winner = Users.COMPUTER
                losses += 1
            }
            userChoice.value == computerChoice.value -> {
                winner = Users.NONE
                draws += 1
            }
        }

        match_result.text = getString(winner.winMessage)

        storeGameResult(userChoice, computerChoice, winner)
        showUserStats()
    }

    private fun showUserStats() {
        user_stats.text = getString(R.string.match_result, wins, losses, draws)
    }

    private fun storeGameResult(userChoice: Choices, computerChoice: Choices, winner: Users) {
        mainScope.launch {
            val game = Game(
                userChoice.image,
                computerChoice.image,
                winner.id,
                getString(winner.winMessage),
                Date().toString()
            )

            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_open_history -> {
                startActivity(
                    Intent(this@MainActivity, History::class.java)
                )
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
