package enjoyalgorithms.module3

import EWSpiralMatrix.definition
import EWSpiralMatrix.spiralMatrix

object EWSpiralMatrix {

  fun definition(): String = """
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    Example 1:
    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    
    Difficulty: Medium
  """.trimIndent()

  /**
   * Time complexity O(mn)
   * Space complexity O(1)
   */
  fun spiralMatrix(input: Array<Array<Int>>): Array<Int> {
    // Initialise tracking variables
    var rowStart = 0
    var colStart = 0
    var colEnd = input[0].size - 1
    var rowEnd = input.size - 1
    val size = (colEnd + 1) * (rowEnd + 1)

    // Initialise result array
    val result = Array(size) { 0 }
    // val result = arrayOf<Int>()
    var resultIndex = 0

    // Note: Possibly given the values of m and n as parameters

    while (rowStart <= rowEnd && colStart <= colEnd) {
      // Move right
      for (i in colStart..colEnd) {
        result[resultIndex] = input[rowStart][i]
        resultIndex++
      }
      rowStart++
      // if (resultIndex == size) break
      // Move down
      for (j in rowStart..rowEnd) {
        result[resultIndex] = input[j][colEnd]
        resultIndex++
      }
      colEnd--
      // if (resultIndex == size) break
      if (rowStart <= rowEnd) {
        // Move left
        for (k in colEnd downTo colStart) {
          result[resultIndex] = input[rowEnd][k]
          resultIndex++
        }
        rowEnd--
      }
      // if (resultIndex == size) break
      if (colStart <= colEnd) {
        // Move up
        for (l in rowEnd downTo rowStart) {
          result[resultIndex] = input[l][colStart]
          resultIndex++
        }
        colStart++
      }
      // if (resultIndex == size) break
    }

    return result
  }

}

fun main() {
  val problemList = listOf(
    arrayOf(
      arrayOf(1, 2, 3),
      arrayOf(4, 5, 6),
      arrayOf(7, 8, 9),
    ),
    arrayOf(
      arrayOf(1, 2, 3, 4),
      arrayOf(5, 6, 7, 8),
      arrayOf(9, 10, 11, 12),
    ),
    arrayOf(
      arrayOf(1, 2, 3, 4),
      arrayOf(5, 6, 7, 8),
      arrayOf(9, 10, 11, 12),
      arrayOf(13, 14, 15, 16)
    ),
    arrayOf(
      arrayOf(1, 2, 3, 4, 5, 6),
      arrayOf(7, 8, 9, 10, 11, 12),
      arrayOf(13, 14, 15, 16, 17, 18),
      arrayOf(19, 20, 21, 22, 23, 24)
    ),
    arrayOf(arrayOf()),
    arrayOf(arrayOf(1)),
    arrayOf(arrayOf(1, 2, 3)),
  )
  println(definition())
  problemList.forEach { problem ->
    println("Solution: ${spiralMatrix(problem).contentToString()}")
  }
}
