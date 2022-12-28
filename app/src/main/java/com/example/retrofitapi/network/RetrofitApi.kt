package com.example.retrofitapi.network

import com.example.retrofitapi.model.Model
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitApi{

    @GET("/posts")
    suspend fun getPosts() : List<Model>

    @GET("/posts/{id}/comments")
    suspend fun detailPost(@Path("id") id:Int) : List<Model>



}