fun findMedianOfSortedArraysOfEqualSize(inputA: Array<Int>, inputB: Array<Int>): Float {
  fun recursiveStep(aStart: Int, aEnd: Int, bStart: Int, bEnd: Int, n: Int) {
    if (n == 2) return (Math.max(inputA[aStart], inputB[bStart]) + Math.min(inputA[aEnd], inputB[bEnd])) / 2f
    
    val medianA = if (n % 2 == 0) {
      val temp = (aEnd - aStart + 1) / 2
      (inputA[temp] + inputA[temp - 1]) / 2f
    } else {
      val temp = (aEnd - aStart) / 2
      inputA[temp]
    }
    val medianB = if (n % 2 == 0) {
      val temp = (bEnd - bStart + 1) / 2
      (inputB[temp] + inputB[temp - 1]) / 2
    } else {
      val temp = (bEnd - bStart) / 2
      inputB[temp]
    }
    if (medianA == medianB) return medianA
    else if (medianA > medianB) {
      return recursiveStep(aStart, aEnd - n / 2, bStart + n / 2, bEnd, n - n / 2)
    } else {
      return recursiveStep(aStart + n / 2, aEnd, bStart, bEnd - n / 2, n - n / 2)
    }
  }
  if (n == 0) throw Exception("Arrays are empty!")
  if (n == 1) return (inputA[0] + inputB[0]) / 2f
  return recursiveStep(0, inputA.size - 1, 0, inputB.size - 1, inputA.size)
}