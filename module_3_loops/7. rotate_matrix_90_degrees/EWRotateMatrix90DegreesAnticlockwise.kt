package enjoyalgorithms.module3

import EWRotateMatrix90DegreesAnticlockwise.rotateMatrix90DegreesAnticlockwise

object EWRotateMatrix90DegreesAnticlockwise {

  /**
   * Time complexity is O(n^2)
   * Space complexity is O(1)
   */
  fun rotateMatrix90DegreesAnticlockwise(matrix: MutableList<MutableList<Int>>) {
    // Get the transpose of the matrix
    val length = matrix[0].size
    for (row in 0 until length) {
      for (column in row + 1 until length) {
        val temp = matrix[row][column]
        matrix[row][column] = matrix[column][row]
        matrix[column][row] = temp
      }
    }

    // Reverse elements in all columns
    for (column in 0 until length) {
      for (row in 0 until length / 2) {
        val temp = matrix[row][column]
        matrix[row][column] = matrix[length - row - 1][column]
        matrix[length - row - 1][column] = temp
      }
    }
  }
}

fun main() {
  val problemList = listOf(
    mutableListOf(
      mutableListOf(1, 2, 3),
      mutableListOf(4, 5, 6),
      mutableListOf(7, 8, 9)
    ),
    mutableListOf(
      mutableListOf(1, 2, 3, 4),
      mutableListOf(5, 6, 7, 8),
      mutableListOf(9, 10, 11, 12),
      mutableListOf(13, 14, 15, 16)
    )
  )
  problemList.forEach { problem ->
    println("Problem: $problem")
    rotateMatrix90DegreesAnticlockwise(problem)
    println("Solution: $problem")
  }
}