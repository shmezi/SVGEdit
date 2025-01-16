package lol.ezra.svgedit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@OptIn(ExperimentalLayoutApi::class)
@Composable

fun FlowRowScope.Attribute(
   title: String,
   modifier: Modifier = Modifier,
   maxWidth: Boolean = false,
   float: Float? = null,
   int: Int? = null,
   text: String? = null,
   default: Any = "none"
) =
   Card(
      modifier = modifier
         .height(60.dp)
         .padding(3.dp)
         .conditional(maxWidth, truth = { Modifier.fillMaxWidth() }, untrue = { Modifier.weight(1f) })
   ) {
      val value = (float ?: int ?: text ?: default).toString()
      Text("$title:", modifier = Modifier.padding(start = 5.dp))
      Text(value, fontSize = 25.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
   }