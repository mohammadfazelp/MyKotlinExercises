package leetcode

// Question link : https://leetcode.com/problems/number-of-good-pairs/
// A pair (i, j) is called good if nums[i] == nums[j] and i < j.

fun main() {
    val n = NumberOfGoodPairs()
    println("result : ${n.numIdenticalPairs(intArrayOf(1, 2, 3, 1, 1, 3))}")
    println("result : ${n.numIdenticalPairs(intArrayOf(1,1,1,1))}")
    println("result : ${n.numIdenticalPairs(intArrayOf(1,2,3))}")
}

class NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        nums.forEachIndexed { index, value ->
            var i = index + 1
            while (i< nums.size){
                if (value == nums[i]) {
                    result++
                }
                i++
            }
        }
        return result
    }
}