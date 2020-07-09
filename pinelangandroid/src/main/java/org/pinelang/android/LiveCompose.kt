package org.pinelang.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import com.paulovap.android.R
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.pinelang.android.compose.PineColumn
import org.pinelang.android.compose.PineComposable
import org.pinelang.android.compose.PineHScroller
import org.pinelang.android.compose.PineImage
import org.pinelang.android.compose.PineRectangle
import org.pinelang.android.compose.PineRow
import org.pinelang.android.compose.PineText
import org.pinelang.android.compose.PineVScroller
import org.pinelang.android.ui.FlexscriptTheme
import org.pinelang.ast.fbs.Program
import org.pinelang.core.PineEngine
import org.pinelang.lsp.lsp.LSPServer
import org.pinelang.lsp.lsp.ServerImpl

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
                root?.getProp("visible")?.asType<Boolean>()?.expr?.calculation = { false }
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
