package io.github.ajcode404.taro

import java.util.Arrays
import java.util.Stack


private class Solution {
    data class Interval(
        val x: Int,
        val y: Int
    )
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val stack = Stack<Interval>()

        intervals.asSequence().map {
            Interval(it[0], it[1])
        }.sortedBy { it.x }.forEachIndexed { idx, ele ->
            if (idx == 0) {
                stack.push(ele)
            } else {
                if (stack.peek().y >= ele.x) {
                    internalMerge(stack, ele)
                } else {
                    stack.push(ele)
                }
            }
        }

        return stack.map { interval ->
            intArrayOf(interval.x, interval.y)
        }.toTypedArray()
    }

    private fun internalMerge(stack: Stack<Interval>, interval: Interval) {
        val newInterval = Interval(x = stack.peek().x, Math.max(interval.y, stack.peek().y))
        stack.pop()
        stack.push(newInterval)
    }
}

fun main() {
    val arr = arrayOf(intArrayOf(1,3), intArrayOf(2,6),intArrayOf(8,10),intArrayOf(15,18))
    Solution().merge(arr).forEach {
        println(it.contentToString())
    }

}

