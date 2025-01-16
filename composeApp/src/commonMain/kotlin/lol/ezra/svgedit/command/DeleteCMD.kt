package lol.ezra.svgedit.command

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector

class DeleteCMD : Command {
   override val id = "delete"
   override val name = "Delete"
   override val description = "Delete an item"
   override val icon: ImageVector = Icons.Default.Lock
}