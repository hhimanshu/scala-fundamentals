case class Dollars(amount: Double)

def withTax(implicit dollars: Dollars, taxRate: Double) = Dollars(dollars.amount * (1 + taxRate))

object Conversions {
  implicit def doubleToDollars(d: Double) = Dollars(d)
}

withTax(Dollars(200), 0.10)

import Conversions._
withTax(200.0, 0.30) // won't compile, needs Dollars