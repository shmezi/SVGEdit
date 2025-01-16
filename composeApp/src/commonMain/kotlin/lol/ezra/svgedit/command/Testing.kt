package lol.ezra.svgedit.command

val name: String = ""

class Drawable {
   fun drawRect() {}
}

fun x() {
   val name = "hello"
   println("$name ${10 * 2}")
   fun canvas(c: Drawable.() -> Unit) {}


   canvas {
      drawRect()
   }


}