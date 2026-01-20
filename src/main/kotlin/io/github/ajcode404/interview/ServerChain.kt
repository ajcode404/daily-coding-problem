package io.github.ajcode404.interview

import io.github.ajcode404.taro.print

// question: https://www.reddit.com/r/leetcode/comments/1j96wui/amazon_oa_question/#lightbox
class ServerChain {

    fun solve(arr: IntArray, k: Int): IntArray {
        // create a base condition first
        val base = arr[0] + arr[arr.size - 1]

        val cuts = IntArray(arr.size - 1)
        for (i in 0..arr.size - 2) {
            cuts[i] = arr[i] + arr[i+1]
        }
        cuts.sort()


        val min = cuts.take(k - 1).sum() + base
        val max = cuts.takeLast(k - 1).sum() + base

        return intArrayOf(min, max)
    }
}

fun main() {
    val testCase1 = intArrayOf(1, 2, 3, 2, 5)
    ServerChain().solve(testCase1, 3).toList().print()
}