def time(operationName: String, operation: () => Unit): Unit = {
  val startTime = System.currentTimeMillis()
  operation()
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s"======= $operationName took $elapsedTime milliseconds=======")
}

val operation = () => {
  Thread.sleep(1000) // introduced latency
  val numbers = (1 to 100).toList
  println(s"Sum of first hundred numbers is ${numbers.sum}")
}

time("op1", operation)
