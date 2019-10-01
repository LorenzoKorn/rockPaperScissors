package com.example.rockpapersciccors.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpapersciccors.R
import com.example.rockpapersciccors.models.Game
import com.example.rockpapersciccors.models.GameAdapter
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        init()
    }

    private fun init() {
        rvGames.layoutManager = LinearLayoutManager(this@History, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter
        rvGames.addItemDecoration(
            DividerItemDecoration(
                this@History,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}
