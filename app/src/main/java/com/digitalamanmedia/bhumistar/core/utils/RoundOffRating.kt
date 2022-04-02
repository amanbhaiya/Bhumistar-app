package com.digitalamanmedia.bhumistar.core.utils

object RoundOffRating {
    fun rating(r:Float):Int {
        return when (r) {
            in 1.0..1.5 -> {
                1
            }
            in 1.5..2.0 -> {
                2
            }
            in 2.0..2.5 -> {
                2
            }
            in 2.5..3.0 -> {
                3
            }
            in 3.0..3.5 -> {
                3
            }
            in 3.5..4.0 -> {
                4
            }
            in 4.0..4.5 -> {
                4
            }
            in 4.5..5.0 -> {
                5
            }
            else -> {
                0
            }
        }
    }
}