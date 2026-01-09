package io.github.ajcode404.taro

import java.util.Stack

private class ValidParenthesis {
    val stack = Stack<Char>()
    // opening is push
    // closing is pop
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        s.forEach {
            if (isOpen(it)) {
                stack.push(it)
            } else {
                if (stack.isEmpty()) {
                    return false
                }
                if (it != mappingTo(stack.pop())) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
    private fun isOpen(ch: Char): Boolean {
        return ch == '[' || ch == '{' || ch == '('
    }
    private fun mappingTo(ch: Char): Char? {
        return when(ch) {
            '[' -> ']'
            '(' -> ')'
            '{' -> '}'
            else -> null
        }
    }
}

fun main() {
    println(ValidParenthesis().isValid("){"))
}