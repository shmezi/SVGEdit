package lol.ezra.svgedit.data

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Path

/**
 * A se
 */
abstract class Segment(
   vararg nodes: Node,
) {


   private val nodes = mutableStateListOf<Node>()

   init {
      this.nodes.addAll(nodes)
   }

   @Composable
   open fun draw(isSelected: Boolean, path: Path, onSelect: (x: Float, y: Float) -> Unit) {
      for (node in nodes) {
         node.draw(isSelected, path, onSelect)
      }

   }


}