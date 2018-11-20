/* Converting the receiver */
case class Dollars(amount: Double) {
  def prettify: String = "$" + amount
}

implicit def doubleToDollars(d: Double): Dollars = Dollars(d)

10.23 prettify