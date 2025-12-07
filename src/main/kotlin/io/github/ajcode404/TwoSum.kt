package io.github.ajcode404

/**
 * This problem was recently asked by Google.
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
fun twoSum(numbers: List<Int>, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    numbers.forEach { num ->
        if (set.contains(k - num)) {
            return true
        }
        set.add(num)
    }
    return false
}

fun main() {
    val ans = twoSum(listOf(10, 15, 3, 7), 25)
    println(ans)
}
