package enjoyalgorithms.module3

import EWEquilibriumIndexInArray.equilibriumIndex

object EWEquilibriumIndexInArray {

  fun definition(): String = """
    Given an array of integers, find the equilibrium index of the array.
    An equilibrium index is an index such that the summation of the values at the indices before it is equal to the summation of the values at the indices after it.
  """.trimIndent()

  /**
   * Time complexity O(n)
   * Space complexity O(1)
   */
  fun equilibriumIndex(input: List<Int>): Int {
    // Compute the sum of 2 to n
    var rightSum = 0
    for (i in 2 until input.size) {
      rightSum += input[i]
    }

    // Initialise left sum as input[0]
    var leftSum = input[0]

    // loop through the array from 1 to n - 2 (possible equilibrium indices)
    for (i in 1..input.size - 2) {
      if (leftSum == rightSum) return i
      else {
        // Add the value at current index to the leftSum
        leftSum += input[i]
        // Remove the value of the next index from the rightSum
        rightSum -= input[i + 1]
      }
    }

    // when this point is reached, no valid equilibrium index has been found, return false
    return -1
  }
}

fun main() {
  val problemList = listOf(
    listOf(-7, 1, 5, 2, -4, 3, 0),
    listOf(0, 1, 3, -2, -1),
    listOf(1, 2, -2, -1)
  )

  problemList.forEach { problem ->
    println("Problem: $problem, Equilibrium Index: ${equilibriumIndex(problem)}")
  }
}