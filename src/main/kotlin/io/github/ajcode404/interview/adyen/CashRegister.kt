package io.github.ajcode404.interview.adyen

import kotlin.math.roundToLong


enum class Denomination(val value: Long) {
    ONE_HUNDRED(10000L),
    TWENTY(2000L),
    TEN(1000L),
    FIVE(500L),
    TWO(200L),
    ONE(100L),
    QUARTER(25L),
    DIME(10L),
    NICKEL(5L),
    PENN(1L),
}

fun calculateChange(price: Double, cash: Double, registerInventory: Map<String, Long>) {
    val priceCents = (price * 100).roundToLong()
    val cashCents = (cash * 100).roundToLong()

    var changeDueCents = cashCents - priceCents
    if (changeDueCents < 0) {
        println("INSUFFICIENT_FUNDS")
        return
    }
    if (changeDueCents == 0L) {
        println("CLOSED")
        return
    }

    // check if we have enough to return
    val list = mutableListOf<String>()

}


fun main() {
    val map = mapOf(
        "TWENTY" to 1L,
        "TEN" to 0L,
        "FIVE" to 1L,
        "ONE" to 10L,
        "QUARTER" to 4L,
        "DIME" to 5L,
        "NICKEL" to 5L,
        "PENNY" to 10L,
    )

    calculateChange(19.50, 20.0, map)
}

