package com.hourani.retrofitexample.interfaces

import com.hourani.retrofitexample.data.Character
import retrofit2.Call
import retrofit2.http.GET

interface CharacterInterface {
    @GET("1")
    fun getData(): Call<Character>
}