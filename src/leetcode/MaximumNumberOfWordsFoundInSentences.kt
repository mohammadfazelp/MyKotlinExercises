package leetcode
// Question link : https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
import java.util.regex.Pattern

fun main() {
    val m = MaximumNumberOfWordsFoundInSentences()
    val result1 = m.mostWordsFound(arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much"))
    val result2 = m.mostWordsFound(arrayOf("please wait", "continue to fight", "continue to win"))
    println("result : $result1")
    println("result : $result2")
}

class MaximumNumberOfWordsFoundInSentences {

    fun mostWordsFound(sentences: Array<String>): Int {
        val pattern = Pattern.compile("\\s+")
        var max = pattern.split(sentences[0].trim()).count()
        sentences.forEach {
            val words = pattern.split(it.trim())
            if (words.count() > max) {
                max = words.count()
            }
        }

        return max
    }
}