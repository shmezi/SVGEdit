package lol.ezra.svgedit

import io.github.vinceglb.filekit.core.FileKit
import kotlinx.coroutines.runBlocking

class JVMPlatform : Platform {
   override val name: String = "Java ${System.getProperty("java.version")}"
   override fun saveSVG(svg: ByteArray) {
      println(svg)
//      runBlocking { FileKit.saveFile(svg, "filer", "svg") }
   }
}

actual fun getPlatform(): Platform = JVMPlatform()