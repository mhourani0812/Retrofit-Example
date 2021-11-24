package com.hourani.retrofitexample.interfaces

import com.hourani.retrofitexample.data.listOfCharacters
import retrofit2.Call
import retrofit2.http.GET

interface CharacterInterface {
    @GET("character")
    fun getData() : Call<listOfCharacters>
}