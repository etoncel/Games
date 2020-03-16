package com.example.sm4sh.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.sm4sh.R
import com.example.sm4sh.model.Game

class GamesUniversesAdapter(val context: Context, list:List<Game>):
    RecyclerView.Adapter<GamesUniversesAdapter.GamesUniversesItemViewHolder>() {

    data class GameUniverse(
        val name:String,
        var highLighted:Boolean = false
    )
    private val newList = ArrayList<GameUniverse>()

    init {
        val tempList = ArrayList<String>()
        for (game in list) {
            if (!tempList.contains(game.universe)){
                if (game.universe != null)
                tempList.add(game.universe)
            }
        }

        for (universe in tempList){
            newList.add(GameUniverse(universe))
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
        return newList.size
    }

    override fun onBindViewHolder(holder: GamesUniversesItemViewHolder, position: Int) {
        holder.bind(newList[position], position)
    }

    inner class GamesUniversesItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val button:AppCompatButton = itemView.findViewById(R.id.universeButton)
        private var isHighLighted = false
        private var pos = 0

        init {
            button.setOnClickListener(this)
        }

        fun bind(universe: GameUniverse, position: Int) {
            pos = position
            button.text = universe.name
            isHighLighted = universe.highLighted
            highLightButton()
        }

        override fun onClick(v: View?) {
            print("clicked")
            if (!isHighLighted){
                unhighlightAllButtons(pos)
            }
        }

        private fun highLightButton(){
            if (isHighLighted) {
                button.setTextColor(context.resources.getColor(R.color.colorPrimaryDark))
                button.setBackgroundColor(context.resources.getColor(R.color.colorButtonOutline))
            }else{
                button.setTextColor(context.resources.getColor(R.color.colorButtonOutline))
                button.setBackgroundColor(context.resources.getColor(R.color.colorPrimaryDark))
            }
        }
    }

    private fun unhighlightAllButtons(pos:Int) {
        for (universe in newList){
            universe.highLighted = false
        }
        newList[pos].highLighted = true
        notifyDataSetChanged()
    }
}