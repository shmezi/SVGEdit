package lol.ezra.svgedit

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector
import lol.ezra.svgedit.assets.generated.MyIconPack
import lol.ezra.svgedit.assets.generated.myiconpack.Pointer
import lol.ezra.svgedit.assets.generated.myiconpack.Rectangle

enum class Tool(val prettyName: String, val description: String, val icon: ImageVector, val cursor: ImageVector?) {

   Pointer("Pointer", "Select stuff", MyIconPack.Pointer, MyIconPack.Pointer),
   Rect("Rectangle", "Create Rectangles", MyIconPack.Rectangle, MyIconPack.Rectangle)

}