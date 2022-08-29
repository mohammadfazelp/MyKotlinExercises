package leetcode

// https://leetcode.com/problems/merge-sorted-array/

fun main() {
    val arr1 = intArrayOf(0)
    val arr2 = intArrayOf(1)
    val m = 0
    val n = 1
    val merged = MergeSortedArray()
    merged.merge(arr1, m, arr2, n)
}

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val mergedArr = IntArray(m + n)
        for (i in 0 until m) {
            nums1[i].takeIf { it!=0 }?.let {
                mergedArr[i] = nums1[i]
            }
        }
        for (i in 0 until n) {
            nums2[i].takeIf { it!=0 }?.let {
                mergedArr[i + m] = nums2[i]
            }
        }
        mergedArr.sort()
        mergedArr.forEach {
            println(it)
        }
    }
}