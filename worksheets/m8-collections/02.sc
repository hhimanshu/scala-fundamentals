val numbers = List(2.39, 3.54, 4.50, 3.21)
/* foldLeft examples */
val sumL: Double = numbers.foldLeft(0.0)((b, a) => b + a)
val minimumL: Double = numbers.foldLeft(numbers.head)((b, a) => b min a)
val maximumL: Double = numbers.foldLeft(numbers.head)((b, a) => b max a)
val productL: Double = numbers.foldLeft(1.0)((b, a) => b * a)


/* foldRight examples */
val sumR: Double = numbers.foldRight(0.0)((b, a) => b + a)
val minimumR: Double = numbers.foldRight(numbers.head)((b, a) => b min a)
val maximumR: Double = numbers.foldRight(numbers.head)((b, a) => b max a)
val productR: Double = numbers.foldRight(1.0)((b, a) => b * a)


/* fold examples */
val sum: Double = numbers.fold(0.0)((b, a) => b + a)
val minimum: Double = numbers.fold(numbers.head)((b, a) => b min a)
val maximum: Double = numbers.fold(numbers.head)((b, a) => b max a)
val product: Double = numbers.fold(1.0)((b, a) => b * a)
