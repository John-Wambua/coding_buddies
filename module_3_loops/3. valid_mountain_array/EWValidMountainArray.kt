package enjoyalgorithms.module3

import EWValidMountainArray.definition
import EWValidMountainArray.solution

object EWValidMountainArray {
  fun definition(): String = """
    Given an array of integers, check if the array is a valid mountain array.
  """.trimIndent()

  /**
   * Time Complexity is O(n)
   * Space complexity is O(1)
   */
  fun solution(list: List<Int>): Boolean {
    // If the number of elements is less than 3 return false
    if (list.size < 3) return false

    // If the first element is greater than the second element return false
    else if (list[0] > list[1]) return false

    // Initialise our peak tracking variable
    var i = 1

    // This first loop finds the peak index and will be run k times
    // where k is the index of the peak and k <= n
    while (i < list.size - 1) {
      if (list[i] < list[i + 1]) { // Strictly ascending
        i++
      } else break
    }

    // We've established our peak

    // Check if our peak is equal to the last index
    if (i == list.size - 1) return false

    // This second loop checks that from the peak towards the end of the array
    // elements are in strictly descending order
    // This loop runs n - k times
    while (i < list.size - 1) {
      if (list[i] > list[i + 1]) { // Strictly descending
        i++
      } else return false
    }

    // When this point is reached, the input is a valid mountain array
    return true
  }
}

fun main() {
  val problemList = listOf(
    listOf(5, 2, 1, 4),
    listOf(5, 8, 8),
    listOf(1, 2, 4, 2),
    listOf(),
    listOf(1, 2),
    listOf(3, 4, 3),
    listOf(7, 7, 8, 8, 6)
  )
  println(definition())
  problemList.forEach { problem ->
    println("Problem: $problem, IsValidMountainArray?: ${solution(problem)}")
  }
}