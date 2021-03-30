package com.example.myapplication

import android.app.Application
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val repository:Repository = (application as ArchApplication).repository

    private var _posts = MutableLiveData<Resource<Post>>()
    var posts:LiveData<Resource<Post>> = _posts

    fun loadPosts(imageView: ImageView, parent:ViewGroup, context:Context){
        viewModelScope.launch(Dispatchers.IO){
            repository.getView(imageView, parent, context)
            /*_posts.postValue(Resource.Loading<Post>())
            try {
                var result = repository.getPosts(id)
                _posts.postValue(Resource.Success<Post>(result))
            }
            catch (throwable:Throwable){
                _posts.postValue(Resource.Error<Post>("error"))
            }*/
        }
    }
}