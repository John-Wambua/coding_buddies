/*
	m and n
	objective: find the gcd of m and n
	gcd is the greatest factor which is a factor of both m and n

	40, 32 = 8
	40: 1, 2, 4, 5, 8, 10, 20, 40
	32: 1, 2, 4, 8, 16, 32

	60, 40 = 20
	60: 1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60
	40: 1, 2, 4, 5, 8, 10, 20, 40

	edge cases
	- m is zero; n is the gcd
	- n is zero; m is the gcd
	- both m and n are zero; gcd undefined
	- m divisible by n; n is the gcd
	- n divisible by m; m is the gcd

	potential questions
	- are m and n always positive numbers?
	- can you get the gcd of a non-positive number?

	potential solutions:
 	- get the factors of each number; get the largest common factor in both numbers
 */

// Time complexity: O(m + n)
// Space complexity: O(m * k) where k denotes the coefficient that gives the total number of factors of m, k is always than 1
// Can interchange m and n so that m is always the smaller number
fun gcd(m: Int, n: Int): Int? {
  // Handle edge cases
  if (m == 0) {
    if (n == 0) return null // If both are zero, gcd is undefined; any number divided by zero is 0
    else return n
  }
  if (n == 0) {
    return m
  }
  if (m % n == 0) return n
  if (n % m == 0) return m
  
  val factorsOfM = hashSet<Int>() // HashSet provides constant cost search, insert and access operations

  for (i in 1..m) {
    if (m % i == 0) factorsOfM.add(i)
  }
  var maxCommonFactor = factorsOfM[0] // 1 will always be the first occuring common factor
  for (j in 1..n) {
    if (n % j == 0) {
     if (factorsOfM.contains(j)) {
       // j is a common factor
       maxCommonFactor = maxCommonFactor.coerceAtLeast(j)
     }
    }
  }
  
  return maxCommonFactor
}

/*
  -- are there any other properties of gcd we can use to optimise our algorithm
  -- finding a number that divides both?
 */

// Time complexity O(min(m,n))
// Space complexity O(1)
fun gcd(m: Int, n: Int): Int? {
  // Handle edge cases
  if (m == 0) {
    if (n == 0) return null // If both are zero, gcd is undefined; any number divided by zero is 0
    else return n
  }
  if (n == 0) {
    return m
  }
  if (m % n == 0) return n
  if (n % m == 0) return m

  val limit = if (m < n) m else n
  var max = 1
  for (i in 1..limit) {
    if (m % i == 0 || n % i == 0) {
      // Check if m / i divides both
      if (m % (m / i) == 0 && n % (m / i) == 0) return m / i
      else if (m % (n / i) == 0 && n % (n / i) == 0) return n / i
      if (m % i == 0 && n % i == 0) {
        max = max.coerceAtLeast(i)
      }
    }
    /*
    else if (m % i == 0) {
      if (m % (m / i) == 0 && n % (m / i) == 0) return m / i
    }
    else if (n % i == 0) {
      if (m % (n / i) == 0 && n % (n / i) == 0) return n / i 
    }
     */
  }
  return max
}