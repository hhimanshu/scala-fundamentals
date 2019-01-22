/* Make the function a curried form */
def time(n: Int)(operation: Int => Unit): Unit = {
  val startTime = System.currentTimeMillis()
  operation(n)
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s"======= took $elapsedTime milliseconds =======")
}

val operation = (n: Int) => {
  Thread.sleep(1000) // introduced latency
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}

// call the curried function
time (100)(operation)

/* Replace the parenthesis with curly braces */
time(100) {operation}

/* Implement the function literal in curly braces */
time(1000000) { n: Int =>
  val numbers = (1 to n).toList
  println(s"Sum of first $n numbers is ${numbers.sum}")
}