package com.example.sm4sh.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sm4sh.R

import kotlinx.android.synthetic.main.fragment_games.*

import com.example.sm4sh.data.server.Response

// Show the games List
class GamesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val response = Response()
        response.getGamesList {
            games_list_filter_recyclerView.adapter = GamesUniversesAdapter(it)

            val adapter = GamesAdapter(activity!!.applicationContext, it)
            games_list_recyclerView.adapter = adapter
        }



    }




}
