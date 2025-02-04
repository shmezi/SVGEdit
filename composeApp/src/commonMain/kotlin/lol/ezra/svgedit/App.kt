package lol.ezra.svgedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lol.ezra.svgedit.document.*
import lol.ezra.svgedit.ui.Tool
import lol.ezra.svgedit.ui.components.Attribute
import lol.ezra.svgedit.ui.components.EditPanel
import lol.ezra.svgedit.ui.pages.DocumentEditor
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Example data. States should be included inside actual functions :)
 */
var settings = EditorSettings()

var selectedTool = mutableStateOf(Tool.Pointer)


@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
fun App() {


   var selectedTool by selectedTool

//   EqualXRule(a, b)
//   EqualXRule(c, d)
//   EqualYRule(a, d)
//   EqualYRule(b, c)

   MaterialTheme {


      Box(contentAlignment = Alignment.BottomEnd) {
         Row(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
            NavigationSuiteScaffold(
               modifier = Modifier.width(70.dp).zIndex(10f),
               navigationSuiteItems = {
                  settings.tools.forEach {
                     item(
                        icon = {
                           Icon(
                              it.icon,
                              contentDescription = it.description
                           )
                        },
                        label = { Text(it.prettyName) },
                        selected = it == selectedTool,
                        onClick = { selectedTool = it },
                        modifier = Modifier.zIndex(10f)
                     )
                  }
               }
            )
            DocumentEditor(settings, Document("document", Size(1980, 1080), listOf()), selectedTool)
            EditPanel(settings) {
               Attribute("Name", text = "Project", maxWidth = true)
               Attribute("X", float = 0f)
               Attribute("Y", float = 0f)
            }

         }

         val statement = settings.rightWidth.value < 150
         FloatingActionButton({
            settings.rightWidth.value = if (statement) 200f else 0f
         }, modifier = Modifier.padding(20.dp)) {
            Icon(
               if (statement) Icons.AutoMirrored.Filled.ArrowBack else Icons.AutoMirrored.Filled.ArrowForward,
               "Reset right width"
            )
         }
      }
   }
}



