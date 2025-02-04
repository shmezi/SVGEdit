package lol.ezra.svgedit.document.segments

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Path
import lol.ezra.svgedit.document.Node
import lol.ezra.svgedit.document.Segment

/**
 * Defines a Line [Segment].
 * @param first The previous that will be used to connect to the [second] node forming a line.
 * @param second A new Node in which to draw the line to.
 * Forms a line from the previous node (Should be) [first] to a new node [second].
 */
class Line(private val first: Node, private val second: Node) : Segment {

   override val nodes = mutableStateListOf(first, second)

   override fun draw(path: Path) {

      path.lineTo(second.x.value, second.y.value)

   }

   override fun toSVG() = "M ${second.x} ${second.y}"

   override fun contains(x: Float, y: Float) {
      TODO("Not yet implemented")
   }

   override fun onSelect(isSelected: Boolean) {
      TODO("Not yet implemented")
   }

   override fun move(x: Float, y: Float): Boolean {
      TODO("Not yet implemented")
   }
}