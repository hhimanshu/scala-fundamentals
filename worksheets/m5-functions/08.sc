import java.time.LocalDateTime

def division(numerator: Int, denominator: Int): Double = numerator / denominator

/**
  * Order matters
  * numerator = 20
  * denominator = 10
  */
division(20, 10)

/* order does not matter anymore */
division(denominator = 10, numerator = 20)


def log(message: String, eventTime: LocalDateTime = LocalDateTime.now): Unit = {
  println(s"$eventTime -> $message")
}

log("Hello Martin!", LocalDateTime.of(2018, 6, 12, 0, 0, 0))
log("I am getting better with Scala!")
