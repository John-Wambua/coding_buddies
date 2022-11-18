import EWRecursiveSum.definition
import EWRecursiveSum.recursiveSumIncrementingIndex
import EWRecursiveSum.recursiveSumSlicingArray

object EWRecursiveSum {
  fun definition(): String = """
    Create a recursive function that sums all the numbers in a given array
    def sum(arr):
      total = 0
      for x in arr:
        total += x
      return total
  """.trimIndent()

  /**
   * The recurrence relation of this algorithm is:
   * T(n) = n - 1 + (n - 1) c
   * Evaluating this gives us O(n^2) as the algorithm's time complexity
   * The space complexity is also O(n^2)
   * With each recursive call, we reduce the size of the input by 1
   */
  fun recursiveSumSlicingArray(input: Array<Int>, sum: Int = 0): Int {
    if (input.size == 0) return 0
    else if (input.size == 1) return sum + input[0]
    return recursiveSumSlicingArray(input.sliceArray(1 until input.size), sum + input[0])
  }

  /**
   * The recurrence relation of this algorithm is:
   * T(n) = n - 1 + c
   * Time complexity is O(n)
   * Space complexity is O(n)
   */
  fun recursiveSumIncrementingIndex(input: Array<Int>): Int {
    fun recursiveStep(sum: Int = 0, index: Int = 0): Int {
      if (input.size == 0) return 0
      if (index == input.size - 1) return sum + input[index]
      return recursiveStep(sum + input[index], index + 1)
    }
    return recursiveStep()
  }
}

fun main() {
  val problemList = listOf(
    arrayOf(1, 2, 3, 4, 5),
    arrayOf(20, 40, 60, 80),
    arrayOf(11, 36, 2, 448)
  )
  println(definition())
  problemList.forEach { problem ->
    // Solution 1: Slicing the array
    println("Problem: ${problem.toList()}, Solution (splicing): ${recursiveSumSlicingArray(problem)}")
    // Solution 2: Incrementing index
    println("Problem: ${problem.toList()}, Solution (index): ${recursiveSumIncrementingIndex(problem)}")
  }
}
