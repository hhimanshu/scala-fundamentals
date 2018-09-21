import java.time.LocalDateTime

import scala.annotation.tailrec

// partially applied functions
def sum(a: Int, b: Int, c: Int) = a + b + c

sum(1, 2, 3)

val a = sum _
val b = a(1, _: Int, 3)
a(1, 2, 3) == b(2)


// repeated parameters
def sum(nums: Int*) = nums.sum

val s0 = sum()
val s1 = sum(1)
val s2 = sum(2, 2)
val s3 = sum(10, 20, 30)

val array = Array(10, 20, 30, 40)
// val s4 = sum(array) /* compile time error, but if that's what you have you can do the following */
val s4 = sum(array: _*)

// named arguments
def divide(numerator: Int, denominator: Int): Double = numerator / denominator
val d1 = divide(200,100)

val d2= divide(100, 200) // how to achieve this without worrying about the order? see below
val d3 = divide(denominator = 100, numerator = 200) // order is irrelevant and meaning stays same.
d1 == d3

// Default Parameter Values
def log(message: String, when: java.time.LocalDateTime = LocalDateTime.now()) = println(s"$when: $message")
log("I started learning Scala", LocalDateTime.of(2018, 9, 1, 10, 30))
log("I am getting better with Scala")

// Recursion
// ref: https://stackoverflow.com/questions/33923/what-is-tail-recursion
def sumR(n: Int): Int = {
  if(n == 1) 1
  else n + sumR(n-1)
}

val n = 10
sumR(n)

// local function, default parameter. highlight the icons of recursions, compiler annotation @tailrec
def sumTR(n: Int): Int = {
  @tailrec
  def go(currentNum: Int, totalSoFar: Int = 0): Int = {
    if(currentNum == 0) totalSoFar
    else go(currentNum - 1, totalSoFar + currentNum)
  }
  go(n)
}
sumTR(n)