class Calculator {
  def sumOfSquares(a: Int, b: Int) = {
    def square(n: Int): Int = math.pow(n, 2).intValue()
    square(a) + square(b)
  }

  def multiplyDoubles(a: Int, b: Int) = {
    def double(n: Int): Int = {
      println(s"Parent received $a and $b")
      2 * n
    }
    double(a) * double(b)
  }

  def divisionOfCubes(a: Int, b: Int) = {
    def cube(n: Int): Int = math.pow(n, 3).intValue()
    cube(a) / cube(b)
  }
}

val calc = new Calculator

calc.sumOfSquares(2, 3)
calc.multiplyDoubles(3, 2)
calc.divisionOfCubes(5, 2)