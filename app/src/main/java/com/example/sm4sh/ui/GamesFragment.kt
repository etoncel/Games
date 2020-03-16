package com.example.sm4sh.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sm4sh.R
import com.example.sm4sh.model.Game
import com.example.sm4sh.model.Result
import com.example.sm4sh.server.interfaces.BASE_URL
import com.example.sm4sh.server.interfaces.GamesApi
import kotlinx.android.synthetic.main.fragment_games.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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


        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gamesApi:GamesApi = retrofit.create(GamesApi::class.java)

        val repos: Call<Result> = gamesApi.getGames()

        repos.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable) {


                Log.d("ernesto", "falla")

            }

            override fun onResponse(call: Call<Result>, response: Response<Result>) {

                if (response.isSuccessful){

                    val list:List<Game>? = response.body()?.results

                    val adapter = GamesAdapter(activity!!.applicationContext, list!!)
                    games_list_recyclerView.adapter = adapter

                    Log.d("ernesto", "response: " + response)
                }
                else{
                    Log.d("ernesto", "no exitoso")
                }
            }


        })

    }




}
