package lol.ezra.svgedit

interface Platform {
    val name: String
    fun saveSVG(svg:ByteArray)
}

expect fun getPlatform(): Platform
