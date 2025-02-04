package lol.ezra.svgedit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lol.ezra.svgedit.document.EditorSettings

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditPanel(settings: EditorSettings, content: @Composable FlowRowScope.() -> Unit) {
   Row(modifier = Modifier.zIndex(10f).background(Color.Gray)) {
      var width by settings.rightWidth
      VerticalDivider(
         modifier = Modifier.pointerHoverIcon(PointerIcon.Hand).draggable(rememberDraggableState {
            width -= it
         }, Orientation.Horizontal), thickness = 10.dp
      )

      FlowRow(
         modifier = Modifier.width(with(LocalDensity.current) {
            val w = width.toDp()
            if (w > 200.dp) 200.dp else w
         }),
         maxItemsInEachRow = 2,
         verticalArrangement = Arrangement.Top,
         horizontalArrangement = Arrangement.Center
      ) {

         content()
      }
   }
}
