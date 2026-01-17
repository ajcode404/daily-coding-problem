package io.github.ajcode404.taro

//class MedianOfTwoSortedArray {
//    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//        val (short, large) = if (nums1.size > nums2.size) {
//            nums2 to nums1
//        } else {
//            nums1 to nums2
//        }
//
//        var low = 0
//        var high = short.size
//        while (low <= high) {
//            val median = findMedian(short, low, high)
//            if (short[median] < large[median]) {
//
//            }
//        }
//    }
//
//    // return the index of median
//    private fun findMedian(nums: IntArray, low: Int, high: Int): Int {
//        val median = (low + high) / 2
//        return median
//    }
//}

fun main() {
//    val nums1 = intArrayOf(1,3)
//    val nums2 = intArrayOf(2)
//    MedianOfTwoSortedArray().findMedianSortedArrays(nums1, nums2)
    listOf(-1,0,1,2,-1,-4).sorted().print()
    // [-4 + 1 + 2]
}