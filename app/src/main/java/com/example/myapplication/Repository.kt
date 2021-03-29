package com.example.myapplication

import android.content.Context
import com.example.myapplication.Retrofit.retrofit
import retrofit2.Call

class Repository(context:Context){
    private val reference:ApiServiceInterface by lazy {retrofit.create(ApiServiceInterface::class.java)}

    suspend fun getPosts(id:Int):Post {
        return reference.getPosts(id)
    }


}