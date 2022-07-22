package me.izzp.common


enum class Platform {
    Desktop,
    Android,
}

expect val currentPlatform: Platform