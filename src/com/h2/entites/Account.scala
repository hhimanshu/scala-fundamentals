package com.h2.entites

class Account(c: Customer, p: Product, b: Int) {
  val customer: Customer = c
  val product: Product = p
  var balance: Int = b

  def deposit(amount: Int): Unit = {
    println(s"Depositing $amount to $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    println(s"Withdrawing $amount to $customer account")
    balance -= amount
  }

  override def toString = s"$customer with $product has remaining balance of $balance"
}
