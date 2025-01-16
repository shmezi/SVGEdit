package lol.ezra.svgedit.data

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import lol.ezra.svgedit.pxToDp

/**
 * Defines a single point or object on the plane.
 * @param x Initial X value
 * @param y Initial Y value.
 * @param ignore Whether this node can draw on its own without needing other nodes. (Used for things like image insertion etc.)
 */
open class Node(x: Float, y: Float, val ignore: Boolean = false) {
   var stateX = mutableStateOf(x)
   var stateY = mutableStateOf(y)


   init {

   }

   /**
    * Draw the drawing from current node to the next
    */
   @OptIn(ExperimentalFoundationApi::class)
   @Composable
   open fun draw(isSelected: Boolean, path: Path, onSelect: (x: Float, y: Float) -> Unit) {
      if (!isSelected) return
      Box(
         Modifier.offset(stateX.value.pxToDp() - 0.5.dp, stateY.value.pxToDp() - 0.5.dp).zIndex(3f).draggable2D(
            rememberDraggable2DState {
               stateX.value += it.x
               stateY.value += it.y
            }).size(1.dp).clip(RoundedCornerShape(25)).background(Color(0.7294118f, 0.3019608f, 1.0f))
      )
   }

}