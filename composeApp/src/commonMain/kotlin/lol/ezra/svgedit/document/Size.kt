package lol.ezra.svgedit.document

import androidx.compose.runtime.mutableStateOf

/**
 * The size of an item
 */
class Size(height: Int, width: Int) {
   val height = mutableStateOf(height)
   val width = mutableStateOf(width)
}