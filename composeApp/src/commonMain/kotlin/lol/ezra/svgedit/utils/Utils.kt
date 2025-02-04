package lol.ezra.svgedit.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.toSvg
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


fun RoundedOffset(x: Float, y: Float) = IntOffset(x.roundToInt(), y.roundToInt())


@Composable
fun Float.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }
fun distance(x1: Float, x2: Float, y1: Float, y2: Float) = sqrt((x1-x2).pow(2) + (y1-y2).pow(2))


fun Modifier.conditional(
   condition: Boolean,
   untrue: Modifier.() -> Modifier = { Modifier },
   truth: Modifier.() -> Modifier
): Modifier {
   return if (condition) {
      then(truth(Modifier))
   } else {
      then(untrue(Modifier))
   }
}