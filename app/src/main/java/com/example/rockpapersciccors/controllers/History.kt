package com.example.rockpapersciccors.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpapersciccors.models.Game
import com.example.rockpapersciccors.models.GameAdapter
import kotlinx.android.synthetic.main.activity_history.*
import android.view.MenuItem
import com.example.rockpapersciccors.R


class History : AppCompatActivity() {

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        init()
    }

    private fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "History"

        rvGames.layoutManager = LinearLayoutManager(this@History, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter
        rvGames.addItemDecoration(
            DividerItemDecoration(
                this@History,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_delete_history -> {
                deleteHistory()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun deleteHistory() {
        // delete all records in db
        Log.i("TEST", "Delete")
    }
}
