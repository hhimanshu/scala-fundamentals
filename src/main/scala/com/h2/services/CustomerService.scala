package main.scala.com.h2.services

import java.time.LocalDate
import java.util.UUID

import main.scala.com.h2.entities.{Customer, Email}

trait CustomerService extends CustomerDb {
  /**
    * // todo: (challenge?) how to disallow customer with same details?
    *
    * @param first       : first name for the customer
    * @param last        : last name for the customer
    * @param email       : email for the customer in 'value@domain' format
    * @param dateOfBirth : : date of birth for the customer in 'yyyy/mm/dd' format
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
    saveCustomer(customer)
    customer.id
  }
}
