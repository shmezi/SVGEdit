package lol.ezra.svgedit

import androidx.compose.ui.input.key.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import lol.ezra.svgedit.ui.Tool
import lol.ezra.svgedit.utils.pq
import java.awt.event.*

fun main() = application {
   Window(
      onCloseRequest = ::exitApplication, title = "SVGEdit",
      state = WindowState(placement = WindowPlacement.Maximized), onKeyEvent = {


         if (it.type != KeyEventType.KeyDown) return@Window false
         when (it.key) {

            Key.Escape -> {
               selectedTool.value = Tool.Pointer
            }

            Key.Equals -> {
               if (it.isMetaPressed)
                  settings.scale.value *= 1.1f
            }

            Key.Minus -> {
               if (it.isMetaPressed)
                  settings.scale.value *= 0.9f
            }


            else -> {
               it.key.pq("Pressed!")
            }
         }
         false
      }
   ) {
this.window.addInputMethodListener(object :InputMethodListener{
   override fun inputMethodTextChanged(event: InputMethodEvent?) {
      "T".pq()
   }

   override fun caretPositionChanged(event: InputMethodEvent?) {
"B".pq()   }
})
      App()


   }
}