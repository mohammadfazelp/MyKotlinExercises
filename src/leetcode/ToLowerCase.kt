package leetcode
// Question link : https://leetcode.com/problems/to-lower-case/
fun main() {
    val t = ToLowerCase()
    print(t.toLowerCase("Hello"))
}

class ToLowerCase {
    fun toLowerCase(s: String): String {
        return s.toLowerCase()
    }
}