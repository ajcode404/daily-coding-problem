package io.github.ajcode404.taro

import java.util.PriorityQueue

data class Ele(
    val frequency: Int,
    val number: Int
)
class KFrequentElements {
    val countMap = mutableMapOf<Int, Int>()
    val priorityQueue = PriorityQueue<Ele>(compareByDescending { it.frequency })

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return withPriorityQueue(nums, k)
    }

    private fun shortOne(nums: IntArray, k: Int): IntArray {
        nums.forEach {
            countMap[it] = (countMap[it] ?: 0) + 1
        }
        return countMap.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
    }

    private fun withPriorityQueue(nums: IntArray, k: Int): IntArray {
        nums.forEach {
            countMap[it] = (countMap[it] ?: 0) + 1
        }
        for (entry in countMap) {
            priorityQueue.add(Ele(entry.value, entry.key))
        }
        val arr = IntArray(k)
        for (i in 0..k - 1) {
            arr[i] = priorityQueue.poll().number
        }
        return arr
    }
}

fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    val k = 2
    KFrequentElements().topKFrequent(nums, k).forEach { it.print() }
}