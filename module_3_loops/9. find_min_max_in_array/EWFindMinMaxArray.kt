package enjoyalgorithms.module3

import EWFindMinMaxArray.minAndMaxEvaluatePairs
import EWFindMinMaxArray.minAndMaxEvaluateEachElement
import EWFindMinMaxArray.minAndMaxRecursive

object EWFindMinMaxArray {
  /**
   * Time complexity is O(n)
   * Space complexity is O(1)
   * Number of comparisons:
   * per iteration -> 3
   * number of iterations -> n / 2
   * total -> 3n / 2 -> 1.5n
   */
  fun minAndMaxEvaluatePairs(X: Array<Int>): Pair<Int, Int> {
    if (X.size == 1) return Pair(X[0], X[0])
    var i = if (X.size % 2 == 0) 0 else 1
    var min = if (X.size % 2 == 0) Int.MAX_VALUE else X[0]
    var max = if (X.size % 2 == 0) Int.MIN_VALUE else X[0]
    for (j in i until X.size - 1) {
      val temp = X[j] - X[j + 1]
      if (temp >= 0) {
        min = X[j + 1].coerceAtMost(min)
        max = X[j].coerceAtLeast(max)
      } else {
        min = X[j].coerceAtMost(min)
        max = X[j + 1].coerceAtLeast(max)
      }
      i += 2
    }
    return Pair(min, max)
  }

  /**
   * Time complexity is O(n)
   * Space complexity is O(1)
   * Number of comparisons in the worst-case scenario (elements ordered in descending order):
   * per iteration -> 2 (first comparison returns false, so second comparison has to be evaluated)
   * number of iterations -> n - 1
   * total -> 2n - 2
   */
  fun minAndMaxEvaluateEachElement(X: Array<Int>): Pair<Int, Int> {
    var min = X[0]
    var max = X[0]
    for (i in 1 until X.size) {
      if (X[i] > max) max = X[i]
      else if (X[i] < min) min = X[i]
    }
    return Pair(min, max)
  }

  /**
   * Solution from EnjoyAlgorithms(https://www.enjoyalgorithms.com/blog/find-the-minimum-and-maximum-value-in-an-array/)
   * Time complexity is O(n)
   * Space complexity is O(log n)
   * Recurrence relation is T(n) = T(n/2) + T(n/2) + c
   * no. of comparisons per recursive call -> 2 = c
   * total -> 3n/2 - 2
   */
  fun minAndMaxRecursive(X: Array<Int>, left: Int = 0, right: Int = X.size - 1): Pair<Int, Int> {
    if (left == right) return Pair(X[left], X[left])
    if (left + 1 == right) return Pair(
      X[left].coerceAtMost(X[right]),
      X[left].coerceAtLeast(X[right])
    )
    val middle = (right - left) / 2 + left
    val leftMinMax = minAndMaxRecursive(X, left, middle)
    val rightMinMax = minAndMaxRecursive(X, middle + 1, right)
    return Pair(
      leftMinMax.first.coerceAtMost(rightMinMax.first),
      leftMinMax.second.coerceAtLeast(rightMinMax.second)
    )
  }
}

fun main() {
  val problemList = listOf(
    arrayOf(4, 2, 0, 8, 20, 9, 3),
    arrayOf(-8, -3, -10, -32, -1),
    arrayOf(9, 8, 7, 6, 5, 4, 3),
    arrayOf(0, 8, 7, 6, 5, 4, 3),
    arrayOf(1, 2, 4, 8, 16, 32, 64),
  )
  problemList.forEach { problem ->
    println("Problem: ${problem.contentToString()}")
    println("Solution One: ${minAndMaxEvaluatePairs(problem)}")
    println("Solution Two: ${minAndMaxEvaluateEachElement(problem)}")
    println("Solution Three: ${minAndMaxRecursive(problem)}")
  }
}