package lol.ezra.svgedit.data

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import lol.ezra.svgedit.*
import org.jetbrains.skia.PathEffect
import lol.ezra.svgedit.data.Path as EditorPath

class SVGDocument
   (
   val id: String,
   val description: String,
   val size: Size
) {
   val paths = mutableListOf<EditorPath>()
   val pPath = Path()

   @Composable
   fun draw(x: Float, y: Float, scale: Float) = Box(modifier = Modifier
      .offset { RoundedOffset(x, y) }
      .graphicsLayer {
         scaleX = scale
         scaleY = scale
      }.drawBehind {
         drawPath(pPath, Color.Black)
      }
      .size(size.width.dp, size.height.dp)
      .background(Color.White)

   ) {

      for (path in paths)
         path.draw(true, pPath, { x, y -> })
   }


}