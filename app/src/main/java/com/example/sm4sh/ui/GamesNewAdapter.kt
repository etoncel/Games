package com.example.sm4sh.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
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

class GamesNewAdapter(val context: Context, private val parentLayout:View, private val list: List<Game>) : Adapter<GamesNewAdapter.GameItemViewHolder>() {


    private var filteredList:ArrayList<Game>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.game_item_new_view_holder, parent,false)

        val params = view.layoutParams
        val dimenWidth = (UIUtils.getScreenSizeMaxDimension(context) * 0.14).roundToInt()
        val dimenHeight = (UIUtils.getScreenSizeMaxDimension(context) * 0.25).roundToInt()
        params.height = dimenHeight
        params.width = dimenWidth

        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (filteredList != null){
            return filteredList!!.size
        }
        return list.size
    }

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        if (filteredList != null){
            holder.bind(filteredList!![position])
        }else {
            holder.bind(list[position])
        }
    }

    fun filterByUniverse(universe:String){
        if (universe == "All"){
            filteredList = null
            setGamesTitleCount(list.size)
            parentLayout.visibility = VISIBLE
        }else{
            filteredList = ArrayList(list.filter { it.universe == universe })
            setGamesTitleCount(filteredList!!.size)
            if (filteredList!!.isEmpty()){
                parentLayout.visibility = GONE
            }
        }
        notifyDataSetChanged()
    }

    private fun setGamesTitleCount(count:Int){
        val title = parentLayout.findViewById<AppCompatTextView>(R.id.newGamesTitle)
        title.text = "New ($count)"
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