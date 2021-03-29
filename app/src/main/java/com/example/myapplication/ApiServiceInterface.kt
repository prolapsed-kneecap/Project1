package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {
    @GET("/posts/{id}")
    suspend fun getPosts(@Path(value = "id") id : Int):Post
}