import EWRecursiveCount.definition
import EWRecursiveCount.recursiveCountIndexSolution
import EWRecursiveCount.recursiveCountSubArraySolution

object EWRecursiveCount {

  fun definition(): String = """
    Write a recursive function to count the number of elements in a list / array
  """.trimIndent()

  /**
   * The recurrence relation of this algorithm is
   * T(n) = n - 1 + (n - 1)c
   * Time complexity is O(n^2)
   * Space complexity is O(n^2)
   */
  fun <T> recursiveCountSubArraySolution(input: List<T>, count: Int = 0): Int {
    /*
    // Alternate check: if first item on list is null
    if (list.getOrNull(0) == null) return c
     */
    if (input == listOf<T>()) return count
    // Remove the first element from the list and call solution on the reduced list
    return recursiveCountSubArraySolution(input.slice(1 until input.size), count + 1)
  }

  /**
   * The recurrence relation of this algorithm is
   * T(n) = n - 1 + c
   * Time complexity is O(n)
   * Space complexity is O(n)
   */
  fun <T> recursiveCountIndexSolution(list: List<T>): Int {
    fun recursiveStep(count: Int = 0): Int {
      /*
      // Using Kotlin's getOrNull to determine whether there is an element at the current index / count
      if (list.getOrNull(tentativeCount) == null) return tentativeCount
       */
      // Using a try-catch statement to catch the IndexOutOfBoundsException and return count
      try {
        list[count]
      } catch (e: Exception) {
        when (e) {
          is IndexOutOfBoundsException -> {
            return count
          }
          else -> {
            println(e.message)
            throw e
          }
        }
      }
      return recursiveStep(count + 1)
    }
    return recursiveStep()
  }
}

fun main() {
  println(definition())

  val problemList = listOf(
    listOf(1, 2, 3),
    listOf("Apple", 2, 3.0f),
    listOf(listOf<Int>(), listOf<String>(), listOf<Boolean>())
  )

  problemList.forEach { problem ->
    // Solution 1: Slicing array
    println("Problem: $problem, Solution (splicing): ${recursiveCountSubArraySolution(problem)}")
    // Solution 2: Index variable
    println("Problem: $problem, Solution (index): ${recursiveCountIndexSolution(problem)}")
  }
}
