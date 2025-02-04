package lol.ezra.svgedit.document

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Path

class Pather(vararg segments: Segment, override val nodes: SnapshotStateList<Node>)  : Segment{
   val segments = mutableStateListOf(*segments)

   private val composePath = Path()
   override fun toSVG(): String {
      TODO("Not yet implemented")
   }

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