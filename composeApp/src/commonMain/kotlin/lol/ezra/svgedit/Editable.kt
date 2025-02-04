package lol.ezra.svgedit

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Defines an item on screen that can be selected and moved around.
 */
interface Editable {
   /**
    * Called when this item is selected / unselected
    * @param isSelected Weather the item is now selected or not.
    */
   fun onSelect(isSelected: Boolean)

   /**
    * Move item by an offset
    * @param x X to move by
    * @param y T to move by
    * @return Returns if the item was successfully moved.
    */
   fun move(x: Float, y: Float): Boolean

   /**
    * Move item by an offset
    * @param offset Offset to move by
    * @return Returns if the item was successfully moved.
    *
    */
   fun move(offset: Offset): Boolean = move(offset.x, offset.y)

   /**
    * Draw object to the [DrawScope]
    */
   fun draw(path: Path) {}

   /**
    * Draw object to the [DrawScope]
    */
   fun draw(scope: DrawScope) {}
}