package com.hourani.retrofitexample.helpers

import android.util.Log
import com.hourani.retrofitexample.data.Character
import com.hourani.retrofitexample.data.listOfCharacters
import com.hourani.retrofitexample.interfaces.CharacterInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class retrofitHelper() {
    companion object retrofitCall {
        val BASE_URL = "https://rickandmortyapi.com/api/"
        fun getMyData() {
            var retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(CharacterInterface::class.java)


            var retrofitData = retrofitBuilder.getData()
            retrofitData.enqueue(object : Callback<listOfCharacters> {
                override fun onResponse(call: Call<listOfCharacters>, response: Response<listOfCharacters>) {
                    //TODO: Figure out how to get all the character names from the end point response body.
                    val response = response.body()?.results
                    for(i in response!!) {
                        Log.d("CHARACTER", "" + i.name)
                    }
                }

                override fun onFailure(call: Call<listOfCharacters>, t: Throwable) {
                    Log.d("CHARACTER", "onResponse: failed ")
                }
            })
        }
    }
}