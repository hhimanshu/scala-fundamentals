// free and bound variable. Example of compilation error
// val sum = (x: Int) => x + y

/* If y is known, the compilation works */
var y = 99
val sum = (x: Int) => x + y

sum(1)

/* case 1: free variable changes after function value is created */
var case1Free = 20
val case1Sum = (x: Int) => x + case1Free

case1Sum(80)

case1Free = 10
case1Sum(80)

/* case 2: function value changes the value for free variable */
var case2Sum = 0

val calculateSum = (numbers: Seq[Int]) => numbers.foreach(case2Sum += _)
calculateSum(Seq(1,2,3,4,5,6,7,8,9,10))

case2Sum

/* case 3: the free variable is a local variable of a function */
def multiplier(factor: Int) = (x: Int) => x * factor
val double = multiplier(2)
val triple = multiplier(3)

double(2)
triple(2)