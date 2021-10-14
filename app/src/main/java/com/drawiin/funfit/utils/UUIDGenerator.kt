package com.drawiin.funfit.utils

import com.drawiin.funfit.core.Constants


object UUIDGenerator {
    fun generateUUID() = (1..Constants.UUID.uuidLength)
        .map { Constants.UUID.characters.random() }
        .joinToString("")
}