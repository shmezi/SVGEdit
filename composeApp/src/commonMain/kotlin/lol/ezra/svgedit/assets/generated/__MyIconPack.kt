package lol.ezra.svgedit.assets.generated

import androidx.compose.ui.graphics.vector.ImageVector
import lol.ezra.svgedit.assets.generated.myiconpack.Pointer
import lol.ezra.svgedit.assets.generated.myiconpack.Rectangle
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val MyIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Pointer, Rectangle)
    return __AllIcons!!
  }
