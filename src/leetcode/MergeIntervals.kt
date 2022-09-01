package leetcode

/*
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
fun main() {
    val array = arrayOf(
        intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)
    )
    val arr2 = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
    val arr3 = arrayOf(intArrayOf(1, 4), intArrayOf(1, 4))
    val arr4 = arrayOf(intArrayOf(1, 3))
    val arr5 = arrayOf(intArrayOf(1, 4), intArrayOf(5, 6))
    val arr6 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 4))
    val arr7 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 1))
    val arr8 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 0))
    val arr9 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 1))
    val arr10 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 2))
    val m = MergeIntervals()
    m.merge(array)
}

class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val size = intervals.size
        val list = mutableListOf<IntArray>()
        list.add(intervals[0])
        var i = 1
        while (i < size) {
            val element = intervals[i]
            if (size == i + 1) {
                list.add(element)
                i++
            } else {
                if (element.contentEquals(intervals[size - 1]) && size > 2) {
                    list.add(element)
                    i++
                } else {
                    val prevElement = list[i-1]
                    if (prevElement[1] < element[0]) {
                        list.add(prevElement)
                        i++
                    } else {
                        if (prevElement[0] > element[0] && prevElement[1] > element[1] && prevElement[0] > element[1]) {
                            // [1,4] , [0,2] => [0,4]
                            // Swap
                            list.add(intArrayOf(element[0], element[1]))
                            list.add(intArrayOf(prevElement[0], prevElement[1]))
                        } else {
                            list.add(intArrayOf(min(prevElement[0], element[0]), max(prevElement[1], element[1])))
                        }
                        i += 2
                    }
                }
            }
        }
        val arr = Array(list.size) { intArrayOf(0, 0) }
        list.forEachIndexed { index, value ->
            arr[index] = value
            print("$value ")
        }

        arr.forEach {
            it.forEach { v ->
                print("$v ")
            }
        }
        return arr
    }

    private fun min(a: Int, b: Int): Int {
        var min = a
        if (a > b) {
            min = b
        }
        return min
    }

    private fun max(a: Int, b: Int): Int {
        var max = a
        if (a < b) {
            max = b
        }
        return max
    }
}