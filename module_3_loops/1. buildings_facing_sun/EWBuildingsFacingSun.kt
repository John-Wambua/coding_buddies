package enjoyalgorithms.module3

import EWBuildingsFacingSun.buildingsFacingSun

object EWBuildingsFacingSun {
  fun definition(): String = """
    Given an input array of heights representing heights of buildings, write a program that calculates the number of buildings facing the sunset. It is assumed the heights of all buildings are distinct

    Example
    Input height[] = [7, 4, 8, 2, 9)
    Output = 3
  """.trimIndent()

  /**
   * Time complexity O(n)
   * Space complexity O(1)
   */
  fun buildingsFacingSun(input: Array<Int>): Int {
    var count = 1
    var currentMax = input[0]
    for (i in 1 until input.size) {
      if (input[i] > currentMax) {
        currentMax = input[i]
        count++
      }
    }
    return count
  }
}

fun main() {
  val problem = arrayOf(7, 4, 8, 2, 9)
  println("Problem: ${problem.contentToString()}, Buildings facing sun: ${buildingsFacingSun(problem)}")
}