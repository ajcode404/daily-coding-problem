package io.github.ajcode404.taro

class MedianOfTwoSortedArray {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (shortArray, longArray) = if (nums1.size > nums2.size) {
            nums2 to nums1
        } else {
            nums1 to nums2
        }

        val shortArraySize = shortArray.size
        val longArraySize = longArray.size
        var low = 0
        var high = shortArraySize

        while (low <= high) {
            val partitionShortArray = (low + high) / 2

            val partitionLongArray = (shortArraySize + longArraySize + 1) / 2 - partitionShortArray


            // mid value
            val maxLeftShort = if (partitionShortArray == 0) Int.MIN_VALUE else shortArray[partitionShortArray - 1]
            // mid + 1 value
            val minRightShort = if (partitionShortArray == shortArraySize) Int.MAX_VALUE else shortArray[partitionShortArray]

            val maxLeftLong = if (partitionLongArray == 0) Int.MIN_VALUE else longArray[partitionLongArray - 1]
            val minRightLong = if (partitionLongArray == longArraySize) Int.MAX_VALUE else  longArray[partitionLongArray]


            if (maxLeftShort <= minRightLong && maxLeftLong <= minRightShort) {
                return if ((longArraySize + shortArraySize) % 2 == 0) {
                    (minOf(maxLeftShort, maxLeftLong) + maxOf(minRightLong, minRightShort)) / 2.0
                } else {
                    maxOf(maxLeftShort, maxLeftLong).toDouble()
                }
            } else if (maxLeftShort > minRightLong) {
                high = partitionShortArray - 1
            } else {
                low = partitionShortArray + 1
            }
        }
        return 0.0
    }

}

fun main() {
    val nums1 = intArrayOf(1,2)
    val nums2 = intArrayOf(3, 4)
    MedianOfTwoSortedArray().findMedianSortedArrays(nums1, nums2).print()
    // [-4 + 1 + 2]
}