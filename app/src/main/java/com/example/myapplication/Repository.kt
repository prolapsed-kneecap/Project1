package com.example.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.myapplication.Retrofit.retrofit
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import kotlin.coroutines.coroutineContext


class Repository(context:Context){
    private val reference:ApiServiceInterface by lazy {retrofit.create(ApiServiceInterface::class.java)}

    suspend fun getPosts(id:Int):Post {
        return reference.getPosts(id)
    }
    suspend fun getView(convertView: View?, parent: ViewGroup?, context: Context) {
        var view: ImageView? = convertView as ImageView?
        if (view == null) {
            view = ImageView(context)
        }
        val url = "https://images.unsplash.com/photo-1615421559287-5e6eecec3b80?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max"
        Picasso.get().load(url).into(view)
    }
}