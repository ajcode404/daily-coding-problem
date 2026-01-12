package io.github.ajcode404.taro

import java.util.Arrays

class TrappingRainWater {

    fun trap(height: IntArray): Int {
        val rightMaxArray = IntArray(height.size)
        val leftMaxArray = IntArray(height.size)
        var max = 0
        for (i in 0..height.size - 1) {
            max = maxOf(height[i], max)
            rightMaxArray[i] = max
        }
        max = 0
        for (i in height.size - 1 downTo 0 ) {
            max = maxOf(height[i], max)
            leftMaxArray[i] = max
        }
        var rainWater = 0
        for (i in 0..height.size - 1) {
            rainWater += (minOf(leftMaxArray[i], rightMaxArray[i]) - height[i])
        }
        return rainWater
    }
}

fun main() {
    val array = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    TrappingRainWater().trap(array).print()
}
