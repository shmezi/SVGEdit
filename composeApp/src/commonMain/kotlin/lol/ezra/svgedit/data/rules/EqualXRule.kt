package lol.ezra.svgedit.data.rules

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import lol.ezra.svgedit.data.Node

class EqualXRule(vararg val nodes: Node) {
   init {
      for (node in nodes) {
         for (internalNode in nodes) {
            if (internalNode == node) continue
//            internalNode.stateX = node.stateX

         }
      }
   }

}