package lol.ezra.svgedit

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override fun saveSVG(svg: ByteArray) {
        TODO("Not yet implemented")
    }
}

actual fun getPlatform(): Platform = WasmPlatform()