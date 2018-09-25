class Calculator {

  def double(n: Int): Int = 2 * n

  def square(n: Int): Int = math.pow(n, 2).intValue()

  def cube(n: Int): Int = math.pow(n, 3).intValue()

  def sumOfSquares(a: Int, b: Int) = square(a) + square(b)

  def multiplyDoubles(a: Int, b: Int) = double(a) * double(b)

  def divisionOfCubes(a: Int, b: Int) = cube(a) / cube(b)
}

val calc = new Calculator

calc.sumOfSquares(2, 3)
calc.multiplyDoubles(3, 2)
calc.divisionOfCubes(5, 2)