package com.example.sm4sh.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sm4sh.R
import kotlinx.android.synthetic.main.fragment_games.*
import com.example.sm4sh.data.server.Response
import com.example.sm4sh.model.Game

// Show the games List
class GamesFragment : Fragment() {

    lateinit  var newGamesAdapter:GamesNewAdapter
    lateinit var popularGamesAdapter:GamesPopularAdapter
    lateinit var gamesAdapter: GamesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val gridLayoutManager = GridLayoutManager(context, 2)
//        gridLayoutManager.isAutoMeasureEnabled = true
//        games_list_recyclerView.isNestedScrollingEnabled = true

        val response = Response()
        response.getGamesList { list ->
            val context = activity!!.applicationContext

            newGamesAdapter = GamesNewAdapter(context, newGamesLayout, getNewGames(list))
            popularGamesAdapter =  GamesPopularAdapter(context, popularGamesLayout, list.filter { game -> game.popular })
            gamesAdapter = GamesAdapter(context, allGamesLayout ,list){
                findNavController().navigate(R.id.games_list_to_details_action)
            }

            games_list_filter_recyclerView.adapter = GamesUniversesAdapter(context, list){ universe ->
                newGamesAdapter.filterByUniverse(universe.name)
                popularGamesAdapter.filterByUniverse(universe.name)
                gamesAdapter.filterByUniverse(universe.name)

            }

            games_list_new_recyclerView.adapter = newGamesAdapter

            games_list_popular_recyclerView.adapter = popularGamesAdapter

            games_list_recyclerView.adapter = gamesAdapter
        }

    }

    private fun getNewGames(list:List<Game>):List<Game>{

        val sortedList:List<Game> = list.sortedBy { game -> game.createdAt }

        for (game in sortedList){
            Log.d("sorted" , game.createdAt )
        }

        return sortedList.subList(0, 6)
    }




}
