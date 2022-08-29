package topics.ds.hashtables
// Useful links :
// https://www.geeksforgeeks.org/kotlin-hashmap/
// https://www.studytonight.com/advanced-data-structures/hash-table-data-structure

/**
 * - The hash table based implementation of HashMap does not guarantees about the order of specified data of key,
 * value and entries of collections.
 * - Kotlin HashMap provides constant time or O(1) complexity for basic operations like get and put.
 * - searching in the HashMap containsKey() is just a get() that throws away the retrieved value, it’s O(1)
 * - Advantages of Direct Address Table: Insertion in O(1) time, Deletion in O(1), Searching in O(1)
 * - Disadvantages of Direct Address Table:
 *    It is not recommended using the direct address table if the key values are very large.
 *    It cannot handle the case where two keys are equal and contain different data.
 * - Advantages of Hash Table : Insertion in O(1) time, Deletion in O(1), Searching in O(1), it maintains the size constraint
 * - Disadvantages of Hash Table: A situation might arise when we get the same bucket location for different keys via
 *   our hash function, this situation is known as collision. Though we can improve the hash quality,
 *   but we can't guarantee that collisions won't take place
 * - Handling Collisions in Hash Table: A good hash function, Linear Probing, Quadratic Probing, Chaining
 * - Applications of Hash Tables: Pattern Matching, Compilers, File Systems
 */

fun main(args: Array<String>) {
    //A simple example of HashMap class define with empty "HashMap of <String, Int>"
    val hashMap: HashMap<String, Int> = HashMap()

    //printing the Empty hashMap
    printHashMap(hashMap)

    //adding elements to the hashMap using put() function
    hashMap["IronMan"] = 3000
    hashMap["Thor"] = 100
    hashMap["SpiderMan"] = 1100
    hashMap["NickFury"] = 1200
    hashMap.put("HawkEye", 1300)

    //replacing some values
    hashMap.replace("Thor" , 2222)

    println("hashMap.get(\"Thor\") : " + hashMap.get("Thor") + "\n")
    //returns the size of hashMap
    println("\n" + "hashMap.size : " + hashMap.size )

    //printing the non-Empty hashMap
    printHashMap(hashMap)
    //using the overloaded print function of Kotlin language to get the same results
    println("hashMap : $hashMap\n")

    //hashMap traversal using a for loop
    for (key in hashMap.keys) {
        println("Element at key $key : ${hashMap[key]}")
    }

    //creating another hashMap object with the previous version of hashMap object
    val secondHashMap: HashMap<String, Int> = HashMap(hashMap)

    println("\n" + "Second HashMap : ")
    for (key in secondHashMap.keys) {
        //using hashMap.get() function to fetch the values
        println("Element at key $key : ${hashMap.get(key)}")
    }

    //this will clear the whole map and make it empty
    println("hashMap.clear()")
    hashMap.clear()

    println("After Clearing : $hashMap")
}

//function to print the hashMap
fun printHashMap(hashMap: HashMap<String, Int>) {
    // isEmpty() function to check whether the hashMap is empty or not
    if (hashMap.isEmpty()) {
        println("hashMap is empty")
    } else {
        println(message = "hashMap : $hashMap")
    }
}
