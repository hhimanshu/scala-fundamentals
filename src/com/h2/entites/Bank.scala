package com.h2.entites

import java.time.LocalDate
import java.util.UUID

class Bank(val name: String,
           val city: String,
           val country: String,
           val email: Email,
           private var products: Map[UUID, Product],
           private var customers: Map[UUID, Customer],
           private var accounts: Map[UUID, Account]) {

  println(s"$name Established 2018.")

  /**
    * // todo: (challenge?) how to disallow customer with same details?
    * @param first: first name for the customer
    * @param last: last name for the customer
    * @param email: email for the customer in 'value@domain' format
    * @param dateOfBirth: : date of birth for the customer in 'yyyy/mm/dd' format
    * @return the customer id for the new customer
    */
  def createNewCustomer(first: String, last: String,
                        email: String, dateOfBirth: String): UUID = {

    def getEmail: Email = {
      val Array(value, domain) = email.split("@")
      Email(value, domain)
    }

    def getDateOfBirth: LocalDate = {
      val Array(year, month, day) = dateOfBirth.split("/")
      LocalDate.of(year.toInt, month.toInt, day.toInt)
    }

    val customer = new Customer(first, last, getEmail, getDateOfBirth)
    addCustomerToBank(customer)
    customer.id
  }

  private def addCustomerToBank(customer: Customer): Unit = {
    customers + (customer.id -> customer)
  }

  /**
    * // todo: (challenge?) how to disallow products of same name?
    * @param name: name of the product
    * @param minBalance: the minimum balance required for the product
    * @param ratePerYear: the rate of interest earned by the end of the year
    * @param transactionsAllowedPerMonth: number of free transactions allowed for the product (optional)
    * @return the product id for the new product
    */
  def addNewDepositProducts(name: String, minBalance: Int, ratePerYear: Double,
                            transactionsAllowedPerMonth: Option[Int]): UUID = {
    val product = name match {
      case "CoreChecking" => new CoreChecking(Dollars(minBalance), ratePerYear)
      case "StudentChecking" => new StudentCheckings(Dollars(minBalance), ratePerYear)
      case "RewardsSavings" => new RewardsSavings(Dollars(minBalance), ratePerYear, transactionsAllowedPerMonth.get)
    }
    addProductToBank(product)
    product.id
  }

  private def addProductToBank(product: Product): Unit = {
    products + (product.id -> product)
  }

//  def openCustomerAccount()


  override def toString: String = s"[$name]" +
    s" - ${products.size} products" +
    s" - ${customers.size} customers" +
    s" - ${accounts.size} accounts"
}
