package com.paulovap.pinelangandroid.components.compose

import androidx.compose.Composable
import androidx.compose.FrameManager
import androidx.compose.invalidate
import androidx.compose.onActive
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.toArgb
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.unit.TextUnit.Companion.Sp
import com.pinescript.core.*

abstract class PineComposable(id: Int) : PineObject(id) {

    var visible: Boolean by boolProp(::visible, initialValue = true)

    @Composable
    abstract fun ComposeComponent()

    @Composable
    open fun ComposeComponent(invalidate: () -> Unit, children: @Composable() () -> Unit) {
        val framer = {
            FrameManager.framed  {
                invalidate()
            }
        }

        onActive(callback = {
            //TODO: for compose we are connection all props,
            // but this might not be necessary for non-ui props
            for (prop in props) {
                connect(prop.name, framer)
            }
            onDispose {
                for (prop in props) {
                    disconnect(prop.name, framer)
                }
            }
        })
        if (visible) {
            children()
        }
    }
}

class PineText(id: Int) : PineComposable(id) {

    companion object {
        val meta = PineMetaObject("Text") { PineText(it) }
    }
    override fun getMeta(): PineMetaObject = meta

    var text: String by stringProp(::text, initialValue = "")
    val color: String by stringProp(::color, initialValue = "#000000")
    val size: Int by intProp(::size, initialValue = 12)

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            Text(text,
                    color = color.parseColor(),
                        fontSize = Sp(size)
             )
        }
    }


    private fun String.parseColor(): Color {
        if (this[0] == '#') {
            // Use a long to avoid rollovers on #ffXXXXXX
            var color = this.substring(1).toLong(16)
            color = if (this.length == 7) {
                // Set the alpha value
                color or -0x1000000
            } else
                Color.Black.toArgb().toLong()
            return Color(color.toInt())
        }
        return Color(0)
    }
}

class PineColumn(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("Column") { PineColumn(it) }
    }
    override fun getMeta(): PineMetaObject = meta

    @Composable
    override fun ComposeComponent()
    {
        super.ComposeComponent(invalidate = androidx.compose.invalidate) {
            Column {
                for (child in children) {
                    if (child is PineComposable) {
                        child.ComposeComponent()
                    }
                }
            }
        }
    }
}