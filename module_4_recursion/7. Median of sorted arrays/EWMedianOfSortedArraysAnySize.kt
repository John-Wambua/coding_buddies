fun findMedianOfMergedSortedArrays(inputA: Array<Int>, inputB: Array: Array<Int>): Float {
  // Compute merged array size
  val total = inputA.size + inputB.size
  // Compute half of merged array size
  val half = total / 2
  // Set the shorter array as the one to be searched through
  var a = inputA; var b = inputB
  if (inputA.size > inputB.size) { a = inputB; b = inputA }
  // Initialise tracking variables
  var left = 0 // First index
  var right = a.length - 1 // Last index
  var median: Float = 0
  while (true) { // Hack: Fix later
    // Compute the greatest index of that denotes the subarray [left, shorterIndex] provided by the shorter array
    val shorterIndex = left + (right - left) / 2
    // Compute the greatest index of the longer subarray that denotes the subarray [0, longerIndex]
    val longerIndex = half - shorterIndex - 2
    val shorterLeft = if (shorterIndex >= 0) a[shorterIndex] else Int.MIN_VALUE
    val shorterRight = if (shorterIndex + 1 < a.size) a[shorterIndex + 1] else Int.MAX_VALUE
    val longerLeft = if (longerIndex >= 0) b[longerIndex] else Int.MIN_VALUE
    val longerRight = if (longerIndex + 1 < b.size && longerIndex >= 0) b[longerIndex + 1] else Int.MAX_VALUE
    if (shorterLeft <= longerRight && longerLeft <= shorterRight) {
      // Median has been found
      if (total % 2 == 0) {
        // Merged array even
        median = (shorterLeft.coerceAtLeast(longerLeft) + shorterRight.coerceAtMost(longerRight)) / 2f
        break
      } else {
        // Merged array odd
        median = shorterRight.coerceAtMost(longerRight)
        break
      }
    }
    else if (shorterLeft > longerRight) {
      right = shorterIndex - 1
    }
    else {
      left = shorterIndex + 1
    }
  }
  return median
}