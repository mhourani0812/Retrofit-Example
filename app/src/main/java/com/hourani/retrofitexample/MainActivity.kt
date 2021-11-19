package com.hourani.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://rickandmortyapi.com/api/character/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()
    }
    private fun getMyData() {
        var retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        var retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                Log.d("CHARACTER", ""+response.body())
            }
            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.d("CHARACTER", "onResponse: failed ")
            }
        })
    }
}