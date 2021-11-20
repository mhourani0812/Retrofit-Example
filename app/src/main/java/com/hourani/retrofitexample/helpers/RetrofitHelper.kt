package com.hourani.retrofitexample.helpers

import android.util.Log
import com.hourani.retrofitexample.data.Character
import com.hourani.retrofitexample.interfaces.CharacterInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class retrofitHelper() {
    companion object retrofitCall {
        val BASE_URL = "https://rickandmortyapi.com/api/character/"
        fun getMyData() {
            var retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(CharacterInterface::class.java)

            var retrofitData = retrofitBuilder.getData()
            retrofitData.enqueue(object : Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    //TODO: Figure out how to get all the character names from the end point response body.
                    Log.d("CHARACTER", "" + (response))
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {
                    Log.d("CHARACTER", "onResponse: failed ")
                }
            })
        }
    }
}