package com.example.rockpapersciccors.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpapersciccors.R

class GameAdapter(var games: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_result, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val result: TextView = itemView.findViewById(R.id.result)
        private val date: TextView = itemView.findViewById(R.id.date)
        private val computerImage: ImageView = itemView.findViewById(R.id.computer_image)
        private val userImage: ImageView = itemView.findViewById(R.id.user_image)

        fun bind(game: Game) {
            result.text = game.winner
            date.text = game.date.toString()
            computerImage.setImageResource(game.computerImage)
            userImage.setImageResource(game.userImage)
        }
    }
}