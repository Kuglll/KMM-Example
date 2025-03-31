package com.kuglll.kmm.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform