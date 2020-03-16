package com.example.sm4sh.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.sm4sh.R
import com.example.sm4sh.model.Game
import com.example.sm4sh.ui.utils.UIUtils
import kotlin.math.roundToInt

class GamesAdapter(val context: Context, val list: List<Game>) : Adapter<GamesAdapter.GameItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.game_item_view_holder, parent,false)
        val params = view.layoutParams
        params.height = (UIUtils.getScreenSizeMaxDimension(context) * 0.25).roundToInt()

        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size - 1
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class GameItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val gameImage:AppCompatImageView = itemView.findViewById(R.id.gameImageView)
        private val gameNameTv:AppCompatTextView = itemView.findViewById(R.id.gameNameTextView)
        private val gameUniverseTv:AppCompatTextView = itemView.findViewById(R.id.gameUniverseTextView)

        fun bind(game:Game){
            gameNameTv.text = game.name
            gameUniverseTv.text = game.universe
            Glide.with(context).load(game.imageURL)
                .into(gameImage)
        }

    }
}