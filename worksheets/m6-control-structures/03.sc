/* function with no currying */
def multiplySimple(a: Int, b: Int) = a * b

val a = multiplySimple(2, 10)

/* function with currying */
def multiplyCurry(a: Int)(b: Int) = a * b

val b = multiplyCurry(2)(10)

/* refers to the second function in curried form by partially applying on multipleCurry */
val c = multiplyCurry(2) _
b == c(10)