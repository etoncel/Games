package com.example.sm4sh.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.sm4sh.R
import com.example.sm4sh.model.Game
import com.example.sm4sh.ui.utils.UIUtils
import kotlinx.android.synthetic.main.game_universe_view_holder.view.*
import kotlin.math.roundToInt

class GamesUniversesAdapter(var list:List<Game>):
    RecyclerView.Adapter<GamesUniversesAdapter.GamesUniversesItemViewHolder>() {


    private val newList = ArrayList<String>()

    init {


        for (game in list) {
            if (!newList.contains(game.universe)){
                newList.add(game.universe)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamesUniversesItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.game_universe_view_holder, parent,false)

        return GamesUniversesItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newList.size - 1
    }

    override fun onBindViewHolder(holder: GamesUniversesItemViewHolder, position: Int) {
        holder.button.text = newList[position]
    }

    inner class GamesUniversesItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button:AppCompatButton = itemView.findViewById(R.id.universeButton)
    }
}