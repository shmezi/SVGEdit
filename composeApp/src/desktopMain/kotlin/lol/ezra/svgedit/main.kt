package lol.ezra.svgedit

import androidx.compose.ui.input.key.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

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



         }
         false
      }
   ) {

      App()


   }
}