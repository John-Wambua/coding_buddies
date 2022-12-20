// Time complexity: O(n) : O(n / 2)
// Space complexity: O(1)
fun floorSquareRoot(input: Int): Int {
  // Handle edge case where input equals 1
  if (input == 1) return input
  var floor = 1
  for (i in 2..(input / 2)) {
    if (i * i <= input) {
      floor = i
    }
    else break
  }
  return floor
}

// Time complexity: O(log(n / 2) + log(n / 2))
// Space complexity: O(1)
fun floorSquareRoot(input: Int): Int {
  // Handle edge case where input is 0 or 1
  if (input <= 1) return input
  var i = input / 2
  while (i * i > input) {
    i /= 2
  }
  var floor = i
  for (j in i + 1..i * 2) {
    if (j * j <= input) floor = j
    else break
  }
  return floor
}

// Time complexity: O(log (n / 2) + log (n / 2))
// Space complexity O(log (n / 2) + log (n / 2))
fun floorSquareRoot(input: Int): Int {
  
  fun findFloorStart(n: Int, m: Int): Int {
    if m * m > n return findFloorStart(n, m / 2)
    else return m
  }
 
  fun findFloor(n: Int, m: Int): Int {
    if m * m < n findFloor(n, m + 1)
    else if m * m == n return m
    else return m - 1
  }
  
  if (input <= 1) return input
  else return findFloor(input, findFloorStart(input, input / 2))
}