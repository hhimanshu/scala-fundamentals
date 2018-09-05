package com.h2.entites

import java.time.LocalDate

class Customer(val first: String, val last: String,
               val email: Email, val dateOfBirth: LocalDate) {
  override def toString: String = s"$first,$last => $email"
}
