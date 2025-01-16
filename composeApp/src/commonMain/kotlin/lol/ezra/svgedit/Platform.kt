package lol.ezra.svgedit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform