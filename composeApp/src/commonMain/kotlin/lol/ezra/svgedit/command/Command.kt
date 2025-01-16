package lol.ezra.svgedit.command

import androidx.compose.ui.graphics.vector.ImageVector

interface Command {
   val name: String
   val description: String
   val id: String
   val icon: ImageVector
}