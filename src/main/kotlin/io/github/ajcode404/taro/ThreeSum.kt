package io.github.ajcode404.taro

import java.util.PriorityQueue
// [-4, -1, -1, 0, 1, 2]
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var leftPointer = i + 1
            var rightPointer = nums.size - 1
            while (leftPointer < rightPointer) {

                val currentSum = nums[i] + nums[leftPointer] + nums[rightPointer]
                if (currentSum == 0) {
                    result.add(listOf(nums[i], nums[leftPointer], nums[rightPointer]))

                    // skip duplicate numbers
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++
                    }

                    // skip duplicate on the
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--
                    }
                    leftPointer++
                    rightPointer--
                } else if (currentSum > 0) {
                    rightPointer--
                } else {
                    leftPointer++
                }
            }
        }
        return result
    }
}

fun main() {
    ThreeSum().threeSum(intArrayOf(-4, -1, -1, 0, 1, 2)).print()
}
