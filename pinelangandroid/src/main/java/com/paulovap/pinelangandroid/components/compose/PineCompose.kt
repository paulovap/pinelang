package com.paulovap.pinelangandroid.components.compose

import androidx.compose.Composable
import androidx.compose.FrameManager
import androidx.compose.invalidate
import androidx.compose.onActive
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.toArgb
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.preferredSize
import androidx.ui.unit.TextUnit.Companion.Sp
import androidx.ui.unit.dp
import com.pinescript.core.PineMetaObject
import com.pinescript.core.PineObject
import com.pinescript.core.boolProp
import com.pinescript.core.intProp
import com.pinescript.core.stringProp
import dev.chrisbanes.accompanist.coil.CoilImageWithCrossfade

abstract class PineComposable(id: Int) : PineObject(id) {

    var visible: Boolean by boolProp(::visible, initialValue = true)

    @Composable
    abstract fun ComposeComponent()

    @Composable
    open fun ComposeComponent(invalidate: () -> Unit, children: @Composable() () -> Unit) {
        val framer = {
            FrameManager.framed {
                invalidate()
            }
        }

        onActive(callback = {
            // TODO: for compose we are connection all props,
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
        val meta = PineMetaObject(
            "Text",
            docString = """
        ### Type: Text
        The best type there is. Just write something like this:
        

        ```pine
        Text { 
            text: "My incredible text"
            size: 18
            color: "#ff00ff"
        }
        ```
        That is it.
    """.trimIndent()
        ) { PineText(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    var text: String by stringProp(::text, initialValue = "")
    val color: String by stringProp(::color, initialValue = "#000000")
    val size: Int by intProp(::size, initialValue = 12)

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            Text(
                text,
                color = color.parseColor(),
                fontSize = Sp(size)
            )
        }
    }
}

class PineColumn(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("Column") { PineColumn(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
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

class PineRow(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("Row") { PineRow(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            Row {
                for (child in children) {
                    if (child is PineComposable) {
                        child.ComposeComponent()
                    }
                }
            }
        }
    }
}

class PineVScroller(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("VScroller") { PineVScroller(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            VerticalScroller {
                for (child in children) {
                    if (child is PineComposable) {
                        child.ComposeComponent()
                    }
                }
            }
        }
    }
}

class PineHScroller(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("HScroller") { PineHScroller(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            HorizontalScroller {
                for (child in children) {
                    if (child is PineComposable) {
                        child.ComposeComponent()
                    }
                }
            }
        }
    }
}

class PineImage(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("Image") { PineImage(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    val source: String by stringProp(::source, initialValue = "https://loremflickr.com/300/300")

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            CoilImageWithCrossfade(
                data = source,
                modifier = Modifier.preferredSize(128.dp)
            )
        }
    }
}

class PineRectangle(id: Int) : PineComposable(id) {
    companion object {
        val meta = PineMetaObject("Rectangle") { PineRectangle(it) }
    }

    override fun getMeta(): PineMetaObject = meta

    val color: String by stringProp(::color, initialValue = "#000000")

    @Composable
    override fun ComposeComponent() {
        super.ComposeComponent(invalidate = invalidate) {
            Box(
                backgroundColor = color.parseColor()
            ) {
                for (child in children) {
                    if (child is PineComposable) {
                        child.ComposeComponent()
                    }
                }
            }
        }
    }
}

fun String.parseColor(): Color {
    if (this.length < 2)
        return Color(0)
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
