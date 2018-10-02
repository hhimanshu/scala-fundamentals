def time(n: Int, operation: Int => Unit): Unit = {
  val startTime = System.currentTimeMillis()
  operation(n)
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s"======= operation took $elapsedTime milliseconds=======")
}

val operation = (n: Int) => {
  Thread.sleep(1000) // introduced latency
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}

time(100, operation)
