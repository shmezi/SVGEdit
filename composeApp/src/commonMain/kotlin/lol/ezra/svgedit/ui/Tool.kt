package lol.ezra.svgedit.ui

import androidx.compose.ui.graphics.vector.ImageVector
import lol.ezra.svgedit.assets.generated.MyIconPack
import lol.ezra.svgedit.assets.generated.myiconpack.Pointer
import lol.ezra.svgedit.assets.generated.myiconpack.Rectangle

enum class Tool(val prettyName: String, val description: String, val icon: ImageVector, val cursor: ImageVector?) {

   Pointer("Pointer", "Select stuff", MyIconPack.Pointer, MyIconPack.Pointer),
   Rect("Rectangle", "Create Rectangles", MyIconPack.Rectangle, MyIconPack.Rectangle)

}