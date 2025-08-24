package com.example.mediundoctorhome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform