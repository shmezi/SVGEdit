package lol.ezra.svgedit

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.toSvg
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


fun RoundedOffset(x: Float, y: Float) = IntOffset(x.roundToInt(), y.roundToInt())


@Composable
fun Float.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }
fun distance(x1: Float, x2: Float, y1: Float, y2: Float) = sqrt((x1-x2).pow(2) + (y1-y2).pow(2))
@Composable
fun svgDrawing() {
   val path = Path()
   path.lineTo(50f,50f)
   path.lineTo(60f,30f)
   path.lineTo(40f,40f)
   path.lineTo(50f,50f)

   println("SVG: ${path.toSvg(true)}")

}
