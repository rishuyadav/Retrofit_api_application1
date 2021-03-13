 package com.example.retrofitapiapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rf= Retrofit.Builder()
            .baseUrl(Retrofit_interface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        var API = rf.create(Retrofit_interface ::class.java)
        var call = API.posts


        call?.enqueue(object:Callback<List<Postmodel?>?>{
            override fun onResponse(
                call: Call<List<Postmodel?>?>,
                response: Response<List<Postmodel?>?>
            ) {
                var postlist: List<Postmodel>? = response.body() as List<Postmodel>
                var post = arrayOfNulls<String>(postlist!!.size)
                for(i in postlist!!.indices)
                    post[i]= postlist!![i]!!.title
                 var adapter= ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)
                findViewById<ListView>(R.id.listview).adapter = adapter

            }

            override fun onFailure(call: Call<List<Postmodel?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}