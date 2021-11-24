package com.drawiin.core

object Constants {
    object Database {
        const val trainingPath = "training"
    }
    object UUID {
        const val uuidLength = 8
        const val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }
    object Exercises {
        private const val durationInMinutes = 60
        fun getDurationInMinutes(int: Long) = int * durationInMinutes
    }
}
