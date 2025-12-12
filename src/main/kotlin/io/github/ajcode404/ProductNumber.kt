package io.github.ajcode404

fun productArrayWithDivision(input: Array<Int>): Array<Int> {
    val arr = Array(input.size) { 0 }
    var product: Int = 1
    for (i in 0..input.size - 1) {
        product = product * input[i]
    }
    for (i in 0..input.size - 1) {
        arr[i] = product / input[i]
    }
    return arr
}


fun productArrayWithoutDivision(input: Array<Int>): Array<Int> {
    val arr = Array(input.size) { 0 }
    for (i in 0..input.size - 1) {
        var product = 1
        for (j in 0..input.size - 1) {
            if (i == j) {
                continue
            }
            product = product * input[j]
        }
        arr[i] = product
    }
    return arr
}

fun productArrayWithSuffix(input: Array<Int>): Array<Int> {
    val arr = Array(input.size) { 0 }
    val left = Array(input.size) { 0 }
    var lp = 1
    val right = Array(input.size) { 0 }
    var lr = 1
    for (i in 0..input.size - 1) {
        lp = input[i] * lp
        left[i] = lp
    }
    for (i in input.size - 1 downTo 0) {
        lr = input[i] * lr
        right[i] = lr
    }
    for (i in 0..input.size - 1) {
        var pr = 1
        if (i > 0) {
            pr = pr * left[i - 1]
        }
        if (i < input.size - 1) {
            pr = pr * right[i + 1]
        }
        arr[i] = pr
    }
    return arr
}

fun main() {
    val input = arrayOf(1, 2, 3, 4, 5)
    println(productArrayWithDivision(input).contentToString())
    println(productArrayWithoutDivision(input).contentToString())
    println(productArrayWithSuffix(input).contentToString())
}