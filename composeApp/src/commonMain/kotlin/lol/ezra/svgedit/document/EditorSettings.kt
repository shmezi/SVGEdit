package lol.ezra.svgedit.document

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import lol.ezra.svgedit.ui.Tool

data class EditorSettings(
   val tools: SnapshotStateList<Tool> = mutableStateListOf<Tool>().apply { addAll(Tool.entries) },

   var rightWidth: MutableState<Float> = mutableStateOf(200f),
   var scale: MutableState<Float> =  mutableStateOf(10f)
)