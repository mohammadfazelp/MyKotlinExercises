package leetcode

class MaximumNumberOfPairsInArray {
    fun sortColors(nums: IntArray): Unit {
        nums.sort()
    }
}

fun main() {
    val m = MaximumNumberOfPairsInArray()
    val array = intArrayOf(2, 0, 2, 1, 1, 0)
    m.sortColors(array)
    array.forEach {
        print("$it ")
    }
}