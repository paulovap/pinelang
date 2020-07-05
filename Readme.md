# Pinelang

Pinelang or just "Pine" is a scripting language inspired in QML
that sits on top of Kotlin/JVM. The objective is to represent
a tree-like object hierarchy in a declarative way.

It can be use to expose regular Kotlin objects and use it as a script.

For example:

```pine
Object {
    on mount: println("hello world")
}
```  

It will print `hello world` to the standard output.

## Usage

First you must instantiate a PineEngine to be able to evaluate the scripts.

```Kotlin
fun main() {
    var scriptEngine = PineEngine.Builder()
        .registerPineType("Object") { PineObject() }
        .build()

    // Now we evaluate the script
    val root = scriptEngine
            .load("Object { on mount: println('hello world') }")

    // prints "hello world"
   root.dispose() // clean up resources
}
```

## PineObject type

`PineObject` class is the base class for all PineScript types. It consists on
the following properties:
 ```kotlin
class PineObject {
    // unique identifier for the object in a object-tree
    val id: Int 
    
    // children elements of the object
    val children: List<PineObject> 
    
    // map of properties accessible by script
    val nameProps: Map<String, PineProp<*>>
    
    // map of signals (or events) emitted by object
    val signals: Map<String, PineSignal>
    
    // map of all functions exposed to a script
    val callables: Map<String, PineCallable>
}
```

Basically every type exposed to a script needs to extend PineObject.
The basic functionality provided by PineObject are:

## Signals
### `mount`
Signal emitted as object is inserted on the object tree of the script. Useful
for initialization of resources

### `unmount`
Signal emitted as object is removed from the object tree and disposed. Useful
for cleanups.

## Property Binding
TODO

## Functions

#### `println`
Print a PineObject or a primitive type into stdout.


## Creating a new Type

Creating a new Type is quite simple. You just need to extend `PineObject`
 and register the new type on the `PineEngine`
 
 Example:
 
 ```kotlin
// Item provides a basic implementation of all visual items
// on a script
abstract class Item : PineObject() {
    var x: Int by intProp(::x, initialValue = 1)
    var y: Int by intProp(::y, initialValue = 1)
    var width: Int by intProp(::width, initialValue = 50)
    var height: Int by intProp(::height, initialValue = 50)
}
```
To register the type and use on the script, just:
```kotlin
var scriptEngine = PineEngine.Builder()
        .registerPineType("Item") { Item() }
        .build()
var root = scriptEngine.load(""""
    Item { 
        x: 10
        y: 10
        width: 100
        height:100
        on mount: println("x value is " + x)
    }
   """) as Item // prints x value is 10
   println("x is ${root.x}") // prints 10
   println("width is ${root.width}") // prints 100
```

Properties can have the primitive script types: Int, Double, String, Boolean. properties
holding objects will be introduced later.

You can also get events when any of the properties of a object changed. Example:

```kotlin
abstract class Item : PineObject() {
    // pass an object callback for when the property changes
    var x: Int by intProp(::x, initialValue = 1) { println ("x1 is $x") }
    ...
    init {
        // alternative option is to connect to a signal
        // using the connect api
        connect("x") { println ("x2 is $x") }
    }
}
...
fun main() {
   val engine = ...
   val root = engine.load("Item {}") as Item
   // You can connect a callback to any object in the object-tree
   root.connect("x") { println ("x3 is $x") }
   
   // An you can manipulate object's properties as Kotlin primitives 
   root.x = 50
   root.dispose()
}
```

Result:
```bash
x1 is 50
x2 is 50
x3 is 50
```

# Ideas to Evaluate

## Context-aware scopes

Adds the ability to define context-aware scopes. E.g

Define property for specific version of a type:
```
Text {
    text: "Hello World"

    v1.1 { //multiline block
        elipsize: Text.ElipsizeEnd
    }
    // or

    [v1.1] elipsize: Text.ElipsizeEnd

    //by platform

    ios {
        opacity: 0.5
    }

    // maybe it could be nested.

    ios {
        v1.1 {
             elipsize: Text.ElipsizeStart
        }
    }
}
```

We could even have user-defined scopes, that could be resolved at runtime. One use case would be a/b testing.

```
Text {
    [a] text: "This is my A string"
    [b] text: "This is my B String"
}
```

On native size you would define the context: 

```
val engine PineEngine(...)
engine.enableContext("a")
engine.load(script)
```

## Code Generation for properties & Meta

Currently, There is a lot of boilerplate code to make an new Type surface into Pinelang. We could think of additional library to code-genearate those boilerplate code,
probably using annotations on kotlin. Example:

```
class PineText(id: Int) : PineComposable(id) {

    companion object {
        val meta = PineMetaObject(
            "Text",
            docString = """
        ### Type: Text
        The best type there is. Just write something like this:
        

        Text { 
            text: "My incredible text"
            size: 18
            color: "#ff00ff"
        }
        That is it.
    """.trimIndent()) { PineText(it) }
    }
    override fun getMeta(): PineMetaObject = meta

    var text: String by stringProp(::text, initialValue = "")
    val color: String by stringProp(::color, initialValue = "#000000")
    val size: Int by intProp(::size, initialValue = 12)
 ```

 Would change to:

 ```
 /**!Pinelag
    ### Type: Text
    The best type there is. Just write something like this:
        

    Text { 
        text: "My incredible text"
        size: 18
        color: "#ff00ff"
    }
    That is it.
 */
 @ScriptName("Text")
 class PineText(id: Int) : PineComposable(id) {
    
    @StringProp("") var text: String
    
    @StringProp("#000000") val color: String
    
    @IntProp(12) val size: Int
 }
 ```

