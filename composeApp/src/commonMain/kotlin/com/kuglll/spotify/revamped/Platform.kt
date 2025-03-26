package com.kuglll.spotify.revamped

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform