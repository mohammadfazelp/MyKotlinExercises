package leetcode

fun main() {
    val twoSum = Solution()
    val r = twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)
    print("[" + r[0] + "," + r[1] + "]")
}

class Solution {
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