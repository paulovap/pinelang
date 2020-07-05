package com.paulovap.pinelangandroid

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.util.CoilUtils
import okhttp3.OkHttpClient


class LiveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        Coil.setImageLoader(object : ImageLoaderFactory {
            override fun newImageLoader(): ImageLoader {
                val coilOkHttpClient = OkHttpClient.Builder()
                    .cache(CoilUtils.createDefaultCache(this@LiveApplication))
                    .build()

                return ImageLoader.Builder(this@LiveApplication)
                    .okHttpClient(coilOkHttpClient)
                    .build()
            }
        })
    }

    companion object {
        private var instance: LiveApplication? = null

        fun instance (): LiveApplication {
            return instance!!
        }
    }
}