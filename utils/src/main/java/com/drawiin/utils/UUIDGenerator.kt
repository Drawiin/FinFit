package com.drawiin.utils

import com.drawiin.core.Constants


object UUIDGenerator {
    fun generateUUID() = (1..com.drawiin.core.Constants.UUID.uuidLength)
        .map { com.drawiin.core.Constants.UUID.characters.random() }
        .joinToString("")
}
