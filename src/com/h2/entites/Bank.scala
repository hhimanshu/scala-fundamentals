package com.h2.entites

class Bank(val name: String,
           val city: String,
           val country: String,
           val email: Email,
           val products: Set[Product],
           val customers: Set[Customer],
           val accounts: Set[Account]) {
  println(s"$name Established 2018.")
}
