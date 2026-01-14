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

    fun longestPalindrome(s: String): String {
        if (s.length <= 1) return s

        var startIndex = 0
        var endIndex = 0

        for (midIndex in 0..s.length - 1) {
            // center even - consider char
            val palLenEven = expandsAroundCenter(s, midIndex, midIndex)
            // center odd - consider space
            val palLenOdd = expandsAroundCenter(s, midIndex, midIndex + 1)

            val currMaxPalLen = maxOf(palLenOdd, palLenEven)
            if ((endIndex - startIndex) < currMaxPalLen) {
                startIndex = midIndex - (currMaxPalLen - 1) / 2
                endIndex = midIndex + currMaxPalLen / 2
            }
        }

        return s.substring(startIndex, endIndex + 1)
    }

    // return the length of the palindrome
    fun expandsAroundCenter(s: String, leftBoundary: Int, rightBoundary: Int): Int {
        var left = leftBoundary
        var right = rightBoundary

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }

    fun longestPalindromeV3(s: String): String {
        val dp = Array<BooleanArray>(s.length) {BooleanArray(s.length) {false}}

        var result = Pair(0,0)

        for(i in 0..<s.length){
            dp[i][i] = true

            if(i < s.lastIndex && s[i] == s[i+1]) {
                dp[i][i+1] = true
                result = Pair(i, i+1)
            }
        }


        for(k in 2..<s.length){
            for(i in 0..<s.length - k){
                val j = i + k
                dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
                if(dp[i][j] && Math.abs(i-j) > Math.abs(result.first - result.second)) result = Pair(i,j)

            }
        }

        return s.substring(result.first, result.second+1)
    }

    // improve the time and space complexity
    fun isPalindrome(s: String): Boolean {
        return s.reversed() == s
    }
}

fun main() {
    LongestPalindromeSubstring().longestPalindromeV3("aaaaa").print()
}
