val numbers = List(1, 2, 3, 4, 5)

numbers.foreach(n => println(n))

numbers.foreach { n => println(n) }

numbers.foreach { n =>
  val double = n * 2
  println(double)
}

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
