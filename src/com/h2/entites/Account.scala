package com.h2.entites

abstract class Account {
  val customer: Customer
  val product: Product
  def getBalance: Int

}

class DepositsAccount(val customer: Customer,
                      val product: Deposits,
                      private var balance: Int) extends Account {

  def deposit(amount: Int): Unit = {
    require(amount > 0, "amount deposited should be greater than zero.")
    println(s"Depositing $amount to $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    require(amount > 0 && amount <= balance,
      "amount should be greater than zero and requested amount should be less than or equal to balance.")
    println(s"Withdrawing $amount to $customer account")
    balance -= amount
  }

  override def getBalance: Int = balance

  override def toString = s"$customer with $product has remaining balance of $balance"
}

class LendingAccount(val customer: Customer,
                     val product: Lending,
                     private var balance: Int) extends Account {

  def payBill(amount: Int): Unit = {
    require(amount > 0, "The payment must be made for amount greater than zero.")
    println(s"Paying bill of $amount against $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    require(amount > 0, "The withdrawal amount must be greater than zero.")
    println(s"debiting $amount from $customer account")
    balance -= amount
  }

  override def getBalance: Int = balance

  override def toString = s"$customer with $product has remaining balance of $balance"
}
