package lol.ezra.svgedit.command

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector

class PointerCMD : Command {
   override val id = "pointer"
   override val name = "Pointer"
   override val description = "The pointing thing"
   override val icon: ImageVector = Icons.Default.Add

   init {


   }
}