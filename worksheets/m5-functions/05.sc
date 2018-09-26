def sum(a: Int, b: Int, c: Int) = a + b + c

/* case 1: when all arguments are supplied */
val s1 = sum(1, 2, 3)

/* case 2: when one argument is not supplied */
val s2 = sum(_: Int, 2, 3)
val s3 = sum(1, _: Int, 3)
val s4 = sum(1, 2, _: Int)

s2(1)
s3(2)
s4(3)

/* case 3: when 2 arguments are not applied */
val s5 = sum(_: Int, _: Int, 3)
val s6 = sum(1, _: Int, _: Int)
s5(1, 2)
s6(2, 3)

/* case 4: when no arguments are applied */
val s7 = sum(_: Int, _: Int, _: Int)
// note: underscore represent the entire parameter list instead of single parameter
val s8 = sum _

s7(1, 2, 3)
s8(1, 2, 3)
