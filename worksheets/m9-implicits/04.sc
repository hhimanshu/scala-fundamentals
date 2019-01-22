case class Dollars(amount: Double)

object Dollars {
  implicit def doubleToDollars(d: Double) = Dollars(d)
}

def withTax(implicit dollars: Dollars, taxRate: Double) = Dollars(dollars.amount * (1 + taxRate))

withTax(200.0, 0.30)

