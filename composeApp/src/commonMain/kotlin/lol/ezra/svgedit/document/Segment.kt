package lol.ezra.svgedit.document

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import lol.ezra.svgedit.Editable

/**
 * Defines a segment of an action.
 * A Segment can define a Line, Bezier Curve, Text and more!
 * The segment **Should** be draggable around using the [move] Function.
 */
interface Segment  : Editable{
   val nodes: SnapshotStateList<Node>


   /**
    * Convert segment to SVG Path commands.
    * @return An SVG command representation of the path.
    */
   fun toSVG(): String

   /**
    * Check if the coordinate at ([x],[y]) is contained inside the segment.
    * @param x X to check
    * @param y Y to check
    */
   fun contains(x: Float, y: Float)



}