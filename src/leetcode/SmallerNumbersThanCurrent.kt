package leetcode

// Question link : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

fun main() {
    val s = SmallerNumbersThanCurrent()
    s.smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3))
    println("------------")
    s.smallerNumbersThanCurrent(intArrayOf(6, 5, 4, 8))
    println("------------")
    s.smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7))
}

class SmallerNumbersThanCurrent {
    fun smallerNumbersThanCurrent(nums: IntArray?): IntArray? {
        if (nums != null) {
            nums.size.let {
                if (it < 2 || it > 500) return null
            }
            val list = mutableListOf<Int>()
            val sortedNum = nums.toList().sorted()
            nums.forEachIndexed { _, v ->
                run breaking@{
                    sortedNum.forEachIndexed { index, value ->
                        if (v == value) {
                            if (value > 100 || value < 0) return null
                            println("index: $index, value : $value")
                            list.add(index)
                            return@breaking
                        }
                    }
                }
            }
            return list.toIntArray()
        } else return null
    }
}