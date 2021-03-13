package com.example.retrofitapiapplication
import retrofit2.Call
import retrofit2.http.GET

interface Retrofit_interface {
    @get: GET("posts")
    val posts : Call<List<Postmodel?>?>?

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}