package com.paulovap.pinelangandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import com.paulovap.pinelangandroid.components.compose.PineColumn
import com.paulovap.pinelangandroid.components.compose.PineComposable
import com.paulovap.pinelangandroid.components.compose.PineHScroller
import com.paulovap.pinelangandroid.components.compose.PineImage
import com.paulovap.pinelangandroid.components.compose.PineRectangle
import com.paulovap.pinelangandroid.components.compose.PineRow
import com.paulovap.pinelangandroid.components.compose.PineText
import com.paulovap.pinelangandroid.components.compose.PineVScroller
import com.paulovap.pinelangandroid.ui.FlexscriptTheme
import com.pinescript.ast.fbs.Program
import com.pinescript.core.PineEngine
import com.pinescript.core.PineValue
import com.pinescript.lsp.LSPServer
import com.pinescript.lsp.ServerImpl
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LiveCompose : AppCompatActivity() {

    var root: PineComposable? = null
    var err: String? = null
    private val engine = PineEngine.Builder()
        .registerPineType(PineText.meta)
        .registerPineType(PineColumn.meta)
        .registerPineType(PineRow.meta)
        .registerPineType(PineVScroller.meta)
        .registerPineType(PineHScroller.meta)
        .registerPineType(PineRectangle.meta)
        .registerPineType(PineImage.meta)
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
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = stringResource(R.string.title_activity_live_compose))
                        }
                    )
                }
            ) {
                FlexscriptTheme {
                }
            }
        }
    }

    fun runScript(text: String) {
        runOnUiThread {
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
            setContent {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.title_activity_live_compose))
                            }
                        )
                    }
                ) {
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
}
