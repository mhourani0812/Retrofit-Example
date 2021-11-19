package com.hourani.retrofitexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("17")
    fun getData(): Call<Character>
}