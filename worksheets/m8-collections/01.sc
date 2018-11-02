val priceCoffeeByDay: Map[String, Double] = Map(
  "Sunday" -> 2.45,
  "Monday" -> 3.54,
  "Tuesday" -> 4.50,
  "Wednesday" -> 3.21,
  "Thursday" -> 5.11,
  "Friday" -> 2.39,
  "Saturday" -> 5.87
)

val totalSpentOnCoffeeUsingSum = priceCoffeeByDay.values.sum
val minSpentOnCoffeeUsingMin = priceCoffeeByDay.values.min

val totalSpentOnCoffeeUsingReduce = priceCoffeeByDay.values.reduce((a, b) => a + b)

val totalSpentOnCoffeeUsingReduceOther = priceCoffeeByDay.values.reduce(_ + _)

val minSpentOnCoffeeUsingReduce = priceCoffeeByDay.values.reduce(_ min _)
