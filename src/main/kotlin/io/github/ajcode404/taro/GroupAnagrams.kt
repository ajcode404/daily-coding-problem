package io.github.ajcode404.taro


private object GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { str ->
            str.map { it.code }.sorted().joinToString { it.toString() }
        }.map {
            it.value
        }
    }
}

fun main() {
    val o = arrayOf("eat","tea","tan","ate","nat","bat")

    GroupAnagrams.groupAnagrams(o).print()
}

fun Any.print() = println(this)