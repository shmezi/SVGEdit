package lol.ezra.svgedit.document

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Path

/**
 * Stores data of an SVG document¬
 */
class Document(
   name: String,
   val size: Size,
   paths: List<Path> = listOf()
) {
   val name = mutableStateOf(name)
   val paths = mutableStateListOf(*paths.toTypedArray())

}