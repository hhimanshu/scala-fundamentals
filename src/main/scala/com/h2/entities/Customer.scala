package main.scala.com.h2.entities

import java.time.LocalDate

class Customer(f: String, l: String, e: String, dob: LocalDate) {
  val first: String = f
  val last: String = l
  val email: String = e
  val dateOfBirth: LocalDate = dob

  override def toString: String = first + "," + last
}
