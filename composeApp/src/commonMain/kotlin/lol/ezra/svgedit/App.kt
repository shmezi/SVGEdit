package lol.ezra.svgedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import lol.ezra.svgedit.data.SVGDocument
import lol.ezra.svgedit.data.Size
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Example data. States should be included inside actual functions :)
 */
var settings = EditorSettings()
var document by mutableStateOf(SVGDocument("document", "123Document", Size(210, 297)))
var x = mutableStateOf(0f)
var y = mutableStateOf(0f)
var selectedTool = mutableStateOf(Tool.Pointer)


@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
fun App() {
   Column {

      var x by remember { mutableStateOf(1000f) }
      val path = Path()
//      path.lineTo(x+202, 400f)
//      path.lineTo(x+402,200f)
      path.arcTo(
         rect = Rect(
            left = 400f,
            top = -200f,
            right = 1000f,
            bottom = 400f
         ),
         startAngleDegrees = 90f,
         sweepAngleDegrees = 90f,
         forceMoveTo = false,
      )
      path.close()
      val shape = object : Shape {
         override fun createOutline(
            size: androidx.compose.ui.geometry.Size,
            layoutDirection: LayoutDirection,
            density: Density
         ) = Outline.Generic(path)
      }

      Box(Modifier.size(500.dp).clip(shape).background(Color.Red))
      Button({ x += 300 }) { Text("Click") }
   }


//
//   var selectedTool by selectedTool
//   val a = Node(0f, 0f)
//   val b = Node(0f, 40f)
//   val c = Node(60f, 40f)
//   val d = Node(60f, 0f)
//   EqualXRule(a, b)
//   EqualXRule(c, d)
//   EqualYRule(a, d)
//   EqualYRule(b, c)
//   document.paths.add(
//      Path(
//         10f,
//         10f,
//         Line(a, b),
//         Line(b, c),
//         Line(c, d),
//         Line(d, a)
//      )
//   )
//   MaterialTheme {
//
//
//      Box(contentAlignment = Alignment.BottomEnd) {
//         Row(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
//            NavigationSuiteScaffold(
//               modifier = Modifier.width(70.dp).zIndex(10f),
//               navigationSuiteItems = {
//                  settings.tools.forEach {
//                     item(
//                        icon = {
//                           Icon(
//                              it.icon,
//                              contentDescription = it.description
//                           )
//                        },
//                        label = { Text(it.prettyName) },
//                        selected = it == selectedTool,
//                        onClick = { selectedTool = it },
//                        modifier = Modifier.zIndex(10f)
//                     )
//                  }
//               }
//            )
//            DocumentEditor(document, settings, selectedTool)
//            EditPanel(settings) {
//               Attribute("Name", text = "Project", maxWidth = true)
//               Attribute("X", float = x.value)
//               Attribute("Y", float = y.value)
//            }
//
//         }
//         val statement = settings.rightWidth.value < 150
//         FloatingActionButton({
//            settings.rightWidth.value = if (statement) 200f else 0f
//         }, modifier = Modifier.padding(20.dp)) {
//            Icon(
//               if (statement) Icons.AutoMirrored.Filled.ArrowBack else Icons.AutoMirrored.Filled.ArrowForward,
//               "Reset right width"
//            )
//         }
//      }
//   }
}



