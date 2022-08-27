package leetcode
// Question link : https://leetcode.com/problems/palindrome-number/
fun main() {
    val palindromeNumber = PalindromeNumber()
    println(palindromeNumber.isPalindrome(123))
    println(palindromeNumber.isPalindrome(121))
    println(palindromeNumber.isPalindrome(1234321))
    println(palindromeNumber.isPalindrome(1232))
    println(palindromeNumber.isPalindrome(-121))
    println(palindromeNumber.isPalindrome(10))
    println(palindromeNumber.isPalindrome(11))
    println(palindromeNumber.isPalindrome(1001))
    println(palindromeNumber.isPalindrome(123123))
}

class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        val digits = x.toDigits()
        if (digits.size == 2) {
            return digits[0] == digits[1]
        }
        val list1 = digits.subList(0, digits.size / 2)
        val list2 = if (digits.size % 2 == 0) {
            digits.subList(digits.size / 2, digits.size)
        } else {
            digits.subList(digits.size / 2 + 1, digits.size)
        }
        if (list1.asReversed() == list2) {
            return true
        }
        return false
    }

    private fun Int.toDigits(): List<Int> = toString().map { it.toString().toInt() }
}