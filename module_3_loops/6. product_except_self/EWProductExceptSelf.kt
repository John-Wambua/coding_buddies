package enjoyalgorithms.module3

import EWProductExceptSelf.productExceptSelfComputePrefixAndSuffix
import EWProductExceptSelf.productExceptSelfComputePrefixAndSuffixEfficiently
import EWProductExceptSelf.productExceptSelfNestedLoop

object EWProductExceptSelf {

  /**
   * Time complexity is O(n^2)
   * Space complexity is O(1)
   */
  fun productExceptSelfNestedLoop(input: Array<Int>): Array<Int> {
    val result = Array(input.size) { 0 }
    for (i in input.indices) {
      var product = 1
      for (j in input.indices) {
        if (j == i) continue
        else product *= input[j]
      }
      result[i] = product
    }
    return result
  }

  /**
   * Time complexity is O(n)
   * Space complexity is O(n)
   * Source (https://www.enjoyalgorithms.com/blog/product-of-array-except-self/)
   */
  fun productExceptSelfComputePrefixAndSuffix(input: Array<Int>): Array<Int> {
    val prefixProduct = Array(input.size) { 0 }
    prefixProduct[0] = 1
    for (i in 1 until input.size) {
      prefixProduct[i] = prefixProduct[i - 1] * input[i - 1]
    }
    val suffixProduct = Array(input.size) { 0 }
    suffixProduct[input.size - 1] = 1
    for (j in input.size - 2 downTo 0) {
      suffixProduct[j] = suffixProduct[j + 1] * input[j + 1]
    }
    val result = Array(input.size) { 0 }
    for (i in input.indices) {
      result[i] = prefixProduct[i] * suffixProduct[i]
    }
    return result
  }

  /**
   * Time complexity is O(n)
   * Space complexity is O(n)
   * Does not create suffixArray so less space consumed
   * Source (https://www.enjoyalgorithms.com/blog/product-of-array-except-self/)
   */
  fun productExceptSelfComputePrefixAndSuffixEfficiently(input: Array<Int>): Array<Int> {
    val result = Array(input.size) { 0 }
    result[0] = 1
    for (i in 1 until input.size) {
      result[i] = result[i - 1] * input[i - 1]
    }
    var suffixProduct = 1
    for (j in input.size - 1 downTo  0) {
      result[j] = result[j] * suffixProduct
      suffixProduct *= input[j]
    }
    return result
  }
}

fun main() {
  val problemList = listOf(
    arrayOf(2, 1, 3, 4),
    arrayOf(5, 2, 8, 4, 5),
    arrayOf(1, 0, 4, 3, 5),
    arrayOf(1, 1, 1, 1, 1, 1, 1),
    arrayOf(0, 4, 0, 3)
  )
  problemList.forEach { problem ->
    println("Problem: ${problem.toList()}, ProductExceptSelf(nested loop): ${productExceptSelfNestedLoop(problem).toList()}")
    println("Problem: ${problem.toList()}, ProductExceptSelf(compute prefix and suffix): ${productExceptSelfComputePrefixAndSuffix(problem).toList()}")
    println("Problem: ${problem.toList()}, ProductExceptSelf(compute prefix and suffix better): ${productExceptSelfComputePrefixAndSuffixEfficiently(problem).toList()}")
  }
}