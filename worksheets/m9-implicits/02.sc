case class Dollars(amount: Double)

def withTax(dollars: Dollars, taxRate: Double) = Dollars(dollars.amount * (1 + taxRate))

implicit def doubleToDollars(d: Double) = Dollars(d)

withTax(Dollars(200), 0.10)

withTax(200.0, 0.30)

