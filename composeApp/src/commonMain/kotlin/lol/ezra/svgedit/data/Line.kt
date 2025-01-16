package lol.ezra.svgedit.data

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lol.ezra.svgedit.RoundedOffset
import lol.ezra.svgedit.distance
import lol.ezra.svgedit.pxToDp
import kotlin.math.*

/**
 * Rotates the given offset around the origin by the given angle in degrees.
 *
 * A positive angle indicates a counterclockwise rotation around the right-handed 2D Cartesian
 * coordinate system.
 *
 * See: [Rotation matrix](https://en.wikipedia.org/wiki/Rotation_matrix)
 */
fun Offset.rotateBy(
   angle: Float
): Offset {
   val angleInRadians = ROTATION_CONST * angle
   val newX = x * cos(angleInRadians) - y * sin(angleInRadians)
   val newY = x * sin(angleInRadians) + y * cos(angleInRadians)
   return Offset(newX, newY)
}


internal const val ROTATION_CONST = (PI / 180f).toFloat()

class Line(first: Node, second: Node) : Segment(*arrayOf(first, second)) {
   var first = mutableStateOf(first)
   var second = mutableStateOf(second)

   var angle by mutableStateOf(0f)


   @Composable
   override fun draw(isSelected: Boolean, path: Path, onSelect: (x: Float, y: Float) -> Unit) {


      super.draw(isSelected, path, onSelect)
      var first by first
      var second by second
      var firstX by first.stateX
      var firstY by first.stateY
      var secondX by second.stateX
      var secondY by second.stateY

      val rawAngle = (atan2(secondY - firstY, secondX - firstX) * 180 / PI) % 360

      //This code used to convert the angle to a 360 rotation angle. NOT Required anymore :)
      val normalizedAngle = 270 - ((if (rawAngle < 0) abs(rawAngle) else (360 - rawAngle)))
      angle = (if (normalizedAngle < 0) 360 - abs(normalizedAngle) else normalizedAngle).toFloat()
//      angle = rawAngle.toFloat() - 90f

      val length = distance(firstX, secondX, firstY, secondY)
      Text(fontSize = 1.sp,
         text = angle.toString(),
         modifier = Modifier.offset { RoundedOffset((firstX + secondX) / 2, (firstY + secondY) / 2) })
      path.moveTo(firstX,firstY)
      path.lineTo(secondX,secondY)
      path.close()
      Box(Modifier.width(0.5.dp).height(length.pxToDp()).graphicsLayer {
         transformOrigin = TransformOrigin(0f, 0f)
         rotationZ = angle
         translationX = firstX
         translationY = firstY
      }.drawBehind {
//         drawLine(Color.Black, Offset.Zero, Offset(0f, length))

      }.background(Color(0.5372549f, 0.0f, 1.0f, 0.21568628f))

         .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
               var m = (firstY - secondY) / (firstX - secondX)
               if (m == Float.POSITIVE_INFINITY || m == Float.NEGATIVE_INFINITY) m = 0f
               val b1 = firstY - m * firstX
               val distance = abs(m * change.position.x + -1 * change.position.y + b1) / sqrt(m.pow(2) + 1)


               fun finalFunc(x: Float) = -(distance.pow(2))
               fun rotatedFunc(x: Float) = (-1 / m) * x

//               firstX = second.first
//               firstY = second.first

               val coords = dragAmount.rotateBy(angle)
               firstX += coords.x
               secondX += coords.x
               firstY += coords.y
               secondY += coords.y
//               if (angle in (0f .. 90f) || (angle >= 180 && angle < 270)) {
//                  firstX += coords.x
//                  secondX += coords.x
//               } else {
//                  firstY += coords.y
//                  secondY += coords.y
//               }
            }

         })
//      println(angle)

   }
}