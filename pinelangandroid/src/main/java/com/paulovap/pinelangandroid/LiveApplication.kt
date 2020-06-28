package com.paulovap.pinelangandroid

import android.app.Application
import android.util.Log
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import com.paulovap.pinelangandroid.components.compose.PineColumn
import com.paulovap.pinelangandroid.components.compose.PineText
import com.pinescript.core.PineEngine
import com.pinescript.core.PineObject
import com.pinescript.core.PineValue
import com.pinescript.lsp.LSPServer
import com.pinescript.lsp.ServerImpl
import com.pinescript.lsp.sandbox.ui.Rectangle
import kotlin.system.measureTimeMillis


class LiveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.start()
        }

    }
}