package com.example.myapplication

import android.app.Application

class ArchApplication : Application() {
    companion object
    val repository: Repository by lazy { Repository(applicationContext) }
}