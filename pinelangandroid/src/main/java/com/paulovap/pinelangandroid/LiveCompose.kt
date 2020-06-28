package com.paulovap.pinelangandroid

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.tooling.preview.Preview
import com.paulovap.pinelangandroid.components.compose.PineColumn
import com.paulovap.pinelangandroid.components.compose.PineComposable
import com.paulovap.pinelangandroid.components.compose.PineText
import com.paulovap.pinelangandroid.ui.FlexscriptTheme
import com.pinescript.ast.fbs.Program
import com.pinescript.core.*
import com.pinescript.lsp.LSPServer
import com.pinescript.lsp.ServerImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule
import kotlin.system.measureTimeMillis


class LiveCompose : AppCompatActivity() {

    var root: PineComposable? = null
    var err: String? = null
    val engine = PineEngine.Builder()
            .registerPineType(PineText.meta)
            .registerPineType(PineColumn.meta)
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serverImpl = ServerImpl(engine)
        serverImpl.textChangeListener = { runScript(it) }
        val server = LSPServer(serverImpl)
        GlobalScope.launch { // launch a new coroutine in background and continue
            server.startNettyServer("localhost", 8080)
        }

        setContent {
            FlexscriptTheme {
            }
        }
    }

    fun runScript(text: String) {
        var error: String? = null
        try {
            root?.getProp("visible")?.asType<Boolean>()?.value = PineValue.of(false)
            root?.dispose()
            var program: Program? = null
            val compileTime = measureTimeMillis {
                program = engine.compile(text)
            }
            val evalTime = measureTimeMillis {
                root = engine.eval(program!!) as PineComposable
            }
            Log.d("LiveCompose", "Script Compile in $compileTime ms, eval $evalTime ms")


        } catch (e: Exception) {
            error = e.message
        }

        runOnUiThread {
            setContent {
                FlexscriptTheme {
                    if (error == null) {
                        root!!.ComposeComponent()
                    } else {
                        Text(text = "Error: $error")
                    }
                }
            }
        }
    }
}
