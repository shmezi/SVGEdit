package lol.ezra.svgedit.ui.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import lol.ezra.svgedit.document.Pather
import lol.ezra.svgedit.document.Document
import lol.ezra.svgedit.ui.Tool
import lol.ezra.svgedit.document.EditorSettings
import lol.ezra.svgedit.getPlatform


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RowScope.DocumentEditor(settings: EditorSettings, document: Document, tool: Tool) {
   /**
    * An updating width of the current screen
    */
   var screenSize by remember { mutableStateOf(IntSize.Zero) }

   /**
    * The current Y Offset of the document
    */
   var offsetY by remember { mutableStateOf(0f) }

   /**
    * The current X Offset of the document
    */
   var offsetX by remember { mutableStateOf(0f) }

   /**
    * The current selection of paths
    */
   val selection = remember { mutableStateListOf<Pather>() }


   Column(
      modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f).background(Color.LightGray).onGloballyPositioned {
         screenSize = it.size
      }.onPointerEvent(PointerEventType.Scroll) {
         it.changes.forEach {

            offsetX += (it.scrollDelta.x * -(screenSize.width / 100))

            offsetY += (it.scrollDelta.y * -(screenSize.height / 100))
         }

      },
      /*contentAlignment = Alignment.Center*/


   ) {
      Canvas(modifier = Modifier.size(400.dp, 600.dp).graphicsLayer {
         this.scaleX *= settings.scale.value
         this.scaleY *= settings.scale.value
         this.translationX += offsetX
         this.translationY += offsetY
      }.background(Color.White).pointerInput(Unit) {
         detectDragGestures(
            onDragStart = {


            },
            onDragEnd = {

            }) { change, dragAmount ->


         }
      }) {

         getPlatform()
//         getPlatform().saveSVG(path.toSvg(true).encodeToByteArray())

//         drawLine(Color.Black, Offset(f.x.value, f.y.value), Offset(s.x.value, s.y.value))
      }
   }
}