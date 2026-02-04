package io.github.ajcode404.taro

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val smallest = strs.minOrNull() ?: return ""
        var cnt = 0
        for (i in smallest.indices) {
            for (j in 0..strs.size - 2) {
                if (strs[j][i] != strs[j + 1][i]) {
                    println("Here + $i $j")
                    return smallest.take(i)
                }
            }
            cnt++
        }
        return smallest.take(cnt)
    }
}

fun main() {
    LongestCommonPrefix().longestCommonPrefix(arrayOf("flower","flow","flight")).print()
    LongestCommonPrefix().longestCommonPrefix(arrayOf("one","one","one")).print()
    LongestCommonPrefix().longestCommonPrefix(arrayOf("one","one","ones")).print()
    LongestCommonPrefix().longestCommonPrefix(arrayOf("one","one1","one")).print()
    LongestCommonPrefix().longestCommonPrefix(arrayOf("on","one1","one")).print()
//    LongestCommonPrefix().longestCommonPrefix(arrayOf("","","")).print()
}
