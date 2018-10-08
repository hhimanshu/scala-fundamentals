package main.scala.com.h2.entities

object Dollars {
  def apply(a: Int): Dollars = new Dollars(a)
}

class Dollars(val amount: Int) extends AnyVal {
  def +(dollars: Dollars): Dollars = new Dollars(amount + dollars.amount)

  def -(dollars: Dollars): Dollars = new Dollars(amount - dollars.amount)

  def >(dollars: Dollars): Boolean = amount > dollars.amount

  override def toString: String = "$" + amount
}
