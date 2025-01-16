package lol.ezra.svgedit.data

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KProperty


class ExpandedState(initial: Float) {
   val state = mutableStateOf(initial)
   val observer = MutableStateFlow(state.value)
   operator fun setValue(item: Float, property: KProperty<*>, value: String) {
      state.value = item
      observer.value = item
   }

   val value = state

   operator fun getValue(thisRef: Float, property: KProperty<*>) = state.value

}