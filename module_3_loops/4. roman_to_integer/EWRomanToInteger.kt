package enjoyalgorithms.module3

import EWRomanToInteger.romanToDecimal

object EWRomanToInteger {
  fun definition(): String = """
    Given an input string that represents a Roman number, return the decimal representation of that number.
  """.trimIndent()

  // HashMap that provides value lookup at constant time
  private val romanNumeralValueMap = HashMap<Char, Int>()

  init {
    romanNumeralValueMap['I'] = 1
    romanNumeralValueMap['V'] = 5
    romanNumeralValueMap['X'] = 10
    romanNumeralValueMap['L'] = 50
    romanNumeralValueMap['C'] = 100
    romanNumeralValueMap['D'] = 500
    romanNumeralValueMap['M'] = 1000
    // HashMap always contains 7 values
  }

  /**
   * Time Complexity O(n)
   * Space Complexity O(1)
   */
  fun romanToDecimal(numberInRoman: String): Int {
    var result = 0
    var counter = 0
    while (counter < numberInRoman.length - 1) {
      if (counter == numberInRoman.length - 1) {
        // At the last index of the string, no need to make comparison
        result += romanNumeralValueMap[numberInRoman[counter]]!!
        counter++
      } else if (romanNumeralValueMap[numberInRoman[counter]]!! >=
        romanNumeralValueMap[numberInRoman[counter + 1]]!!
      ) {
        result += romanNumeralValueMap[numberInRoman[counter]]!!
        counter++
      } else if (romanNumeralValueMap[numberInRoman[counter]]!! <
        romanNumeralValueMap[numberInRoman[counter + 1]]!!
      ) {
        // Value at current index should be subtracted from the next value
        result = result + romanNumeralValueMap[numberInRoman[counter + 1]]!! -
            romanNumeralValueMap[numberInRoman[counter]]!!
        counter += 2
      } else {
        result += romanNumeralValueMap[numberInRoman[counter]]!!
        counter++
      }
    }
    return result
  }
}

fun main() {
  // Questions:
  // 1 - Do all input strings contain valid roman numerals?
  // 2 - Are all input strings valid roman numbers?
  // 3 - Does the case of the input string matter?
  val problemList = listOf(
    "XL",
    "MCMIV",
    "LVIII",
    "MCMXCIV",
  )
  problemList.forEach { problem ->
    println("Roman Number: $problem, Decimal Value: ${romanToDecimal(problem)}")
  }
}