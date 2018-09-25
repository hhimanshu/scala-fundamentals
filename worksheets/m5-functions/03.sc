def transform(numbers: Seq[Int], f: Int => Int) = numbers.map(number => f(number))

val someNumbers = Seq(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

val numbersIncrementedBy1 = transform(someNumbers, (x: Int) => x + 1)

val numbersSquared = transform(someNumbers, x => math.pow(x, 2).intValue())

val numbersMultipliedBy2 = transform(someNumbers, 2 * _)

