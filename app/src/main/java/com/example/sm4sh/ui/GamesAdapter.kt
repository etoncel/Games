package com.example.sm4sh.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.sm4sh.R

class GamesAdapter : Adapter<GamesAdapter.GameItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.game_item_view_holder, parent,false)

        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {

    }


    inner class GameItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}