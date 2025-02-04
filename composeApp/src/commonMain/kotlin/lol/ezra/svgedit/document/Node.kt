package lol.ezra.svgedit.document

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import lol.ezra.svgedit.Editable

/**
 * Represents a node in a [Document]
 */
class Node(x: Float, y: Float) : Editable {
   var x = mutableStateOf(x)
   var y = mutableStateOf(y)
   private var selected by mutableStateOf(false)


   fun isAt(x: Float, y: Float) = x == this.x.value && y == this.y.value


   override fun onSelect(isSelected: Boolean) {
      selected = isSelected
   }

   override fun move(x: Float, y: Float): Boolean {
      this.x.value += x
      this.y.value += y
      return true
   }

   override fun draw(scope: DrawScope) {
      if (selected) scope.drawCircle(Color.Black, center = Offset(this@Node.x.value, this@Node.y.value), radius = 20f)

   }

}