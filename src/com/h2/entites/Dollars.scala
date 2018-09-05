package com.h2.entites

object Dollars {
  def apply(a: Int): Dollars = new Dollars(a)
}

class Dollars(val amount: Int) extends AnyVal {
  def +(value: Int): Dollars = new Dollars(amount + value)

  def -(value: Int): Dollars = new Dollars(amount - value)

  def >(value: Int): Boolean = amount > value

  override def toString: String = "$" + amount
}
