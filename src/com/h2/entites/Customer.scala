package com.h2.entites

import java.time.LocalDate

class Customer(val first: String, val last: String,
               val email: String, val dateOfBirth: LocalDate) {
  override def toString: String = first + "," + last
}
