package io.github.ajcode404.taro

class LongestPalindromeSubstring {
    fun longestPalindromeV1(s: String): String {
        if (s.length <= 1) {
            return s
        }
        var lp = ""
        for (i in 0..s.length - 1) {
            for (j in i + 1..s.length) {
                val ss = s.substring(i, j)
                if (isPalindrome(ss)) {
                    if (lp.length < ss.length) {
                        lp = ss
                    }
                }
            }
        }
        return lp
    }

    // improve the time and space complexity
    fun isPalindrome(s: String): Boolean {
        return s.reversed() == s
    }
}

fun main() {
    LongestPalindromeSubstring().longestPalindromeV1("ac").print()
}
