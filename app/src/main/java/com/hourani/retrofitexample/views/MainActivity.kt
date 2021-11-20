package com.hourani.retrofitexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hourani.retrofitexample.helpers.retrofitHelper

import com.hourani.retrofitexample.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofitHelper.getMyData()
    }
}