package ru.trinitydigital.customviews

import android.app.Application
import android.content.Context

class CustomViewsApp: Application() {

    override fun onCreate() {
        super.onCreate()


        context = this
    }



    companion object {


        @JvmStatic
        lateinit var context: Application

        fun applicationContext(): Context {
            return context
        }
    }
}