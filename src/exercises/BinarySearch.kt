package exercises


fun main() {
    val sortedList = listOf(3, 4, 4, 19, 23, 25, 29)
    val size = sortedList.size
    print(findElementUsingBinarySearch(17, sortedList, 0, size))
}

fun findElementUsingBinarySearch(v: Int, list: List<Int>, left: Int, right: Int): Int {
    if (left > right) {
        return -1
    }
    val pivot = ((left + right) / 2)
    return if (list[pivot] == v) {
        pivot
    } else {
        if (v < list[pivot]) {
            findElementUsingBinarySearch(v, list, left, pivot - 1)
        } else {
            findElementUsingBinarySearch(v, list, pivot + 1, right)
        }
    }
}
