package main.scala.com.h2.entities

object Dollars {
  val Zero = new Dollars(0)
  def apply(a: Int): Dollars = new Dollars(a)
}

class Dollars(val amount: Int) extends AnyVal with Ordered[Dollars] {
  override def compare(that: Dollars): Int = amount - that.amount

  def +(dollars: Dollars): Dollars = new Dollars(amount + dollars.amount)

  def -(dollars: Dollars): Dollars = new Dollars(amount - dollars.amount)

  override def toString: String = "$" + amount
}