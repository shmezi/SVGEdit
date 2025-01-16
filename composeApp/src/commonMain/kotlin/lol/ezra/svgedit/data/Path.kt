package lol.ezra.svgedit.data

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Path
import kotlin.math.*

/**
 * A series of nodes forming a path that is formed.
 * Note: A path does not need to be a completed shape.
 * @param segments The nodes that are the after this node.
 */
class Path(
   x: Float,
   y: Float,
   vararg segments: Segment,
) : Node(x, y, false) {

   private val svgPath = Path()
   val segments = mutableStateListOf<Segment>()
   init {
      this.segments.addAll(segments)
   }


   @Composable
   override fun draw(isSelected: Boolean, path: Path, onSelect: (x: Float, y: Float) -> Unit) {
      for (seg in segments) {

         seg.draw(isSelected, path, onSelect)
      }

   }
}