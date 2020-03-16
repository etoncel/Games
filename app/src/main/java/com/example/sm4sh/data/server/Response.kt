package com.example.sm4sh.data.server

import android.util.Log
import com.example.sm4sh.model.Game
import com.example.sm4sh.model.Result
import com.example.sm4sh.server.interfaces.BASE_URL
import com.example.sm4sh.server.interfaces.GamesApi
import com.example.sm4sh.ui.GamesAdapter
import com.example.sm4sh.ui.GamesUniversesAdapter
import kotlinx.android.synthetic.main.fragment_games.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Response {

    fun getGamesList(completion:(List<Game>) -> Unit){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gamesApi: GamesApi = retrofit.create(GamesApi::class.java)

        val repos: Call<Result> = gamesApi.getGames()

        repos.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable) {


                Log.d("ernesto", "falla")

            }

            override fun onResponse(call: Call<Result>, response: Response<Result>) {

                if (response.isSuccessful){

                    val list:List<Game>? = response.body()?.results

                    completion(list!!)



                    Log.d("ernesto", "response: " + response)
                }
                else{
                    Log.d("ernesto", "no exitoso")
                }
            }


        })
    }
}