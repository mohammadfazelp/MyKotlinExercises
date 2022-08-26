package leetcode
/*
    https://leetcode.com/problems/two-sum/
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
*/

fun main() {
    val twoSum = TwoSum()
    val r = twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)
    print("[" + r[0] + "," + r[1] + "]")
}

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((i, item) in nums.withIndex()) {
            var index = i
            val possibleSecondValue = target - item

            while (index < nums.size - 1) {
                val result = possibleSecondValue == nums[index + 1]
                if (result) {
                    return intArrayOf(i, index + 1)
                }
                index++
            }
        }
        return intArrayOf()
    }
}