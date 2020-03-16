package com.example.sm4sh.server.interfaces

import android.util.Log
import com.example.sm4sh.model.Game
import com.example.sm4sh.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers

const val BASE_URL = "https://parseapi.back4app.com/"

interface GamesApi {

    @Headers(value =["X-Parse-Application-Id:I9pG8SLhTzFA0ImFkXsEvQfXMYyn0MgDBNg10Aps",
        "X-Parse-REST-API-Key:Yvd2eK2LODfwVmkjQVNzFXwd3N0X7oUuwiMI3VDZ"])
    @GET("classes/Product")
    fun getGames():Call<Result>

/*
    companion object{
        operator fun invoke(){
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .build()

            val gamesApi:GamesApi = retrofit.create(GamesApi::class.java)

            val repos:Call<List<Game>> = gamesApi.getGames()

            repos.enqueue(object : Callback<List<Game>>{
                override fun onFailure(call: Call<List<Game>>, t: Throwable) {


                    Log.d("ernesto", "falla")

                }

                override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {

                    if (response.isSuccessful){

                        Log.d("ernesto", "response: " + response)
                    }
                    else{
                        Log.d("ernesto", "no exitoso")
                    }
                }


            })



        }
    }*/
}