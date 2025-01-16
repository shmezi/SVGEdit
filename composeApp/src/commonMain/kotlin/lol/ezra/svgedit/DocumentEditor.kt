package lol.ezra.svgedit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import lol.ezra.svgedit.data.Node
import lol.ezra.svgedit.data.SVGDocument


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RowScope.DocumentEditor(document: SVGDocument, settings: EditorSettings, tool: Tool) {
   var offsetX by remember { mutableStateOf(0f) }
   var offsetY by remember { mutableStateOf(0f) }
   var screenSize by remember { mutableStateOf(IntSize.Zero) }
   val selection = remember { mutableStateListOf<Node>() }
   Box(
      modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f).background(Color.LightGray)
         .onGloballyPositioned {
            screenSize = it.size
         }
         .onPointerEvent(PointerEventType.Scroll) {
            it.changes.forEach {

               offsetX += (it.scrollDelta.x * -(screenSize.width / 100))

               offsetY += (it.scrollDelta.y * -(screenSize.height / 100))
            }

         },
      contentAlignment = Alignment.Center

   ) {


      document.draw(offsetX, offsetY, settings.scale.value)
   }
}