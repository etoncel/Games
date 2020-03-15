package com.example.sm4sh.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.sm4sh.R
import com.example.sm4sh.ui.utils.UIUtils
import kotlin.math.roundToInt

class GamesAdapter : Adapter<GamesAdapter.GameItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.game_item_view_holder, parent,false)
        val params = view.layoutParams
        params.height = (UIUtils.getScreenSizeMaxDimension(context) * 0.22).roundToInt()

        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        holder.gameNameTv.text = "Game Name"
        holder.gameUniverseTv.text = "Game Universe"
    }


    inner class GameItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gameNameTv:AppCompatTextView = itemView.findViewById(R.id.gameNameTextView)
        val gameUniverseTv:AppCompatTextView = itemView.findViewById(R.id.gameUniverseTextView)

    }
}