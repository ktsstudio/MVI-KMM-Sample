package ru.kts.mobile.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform