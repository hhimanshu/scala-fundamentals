package main.scala.com.h2.entities

class Bank(n: String, c: String, co: String, e: String, ps: Set[Product],
           cs: Set[Customer], as: Set[Account]) {
  println(s"$n Established 2018.")
  val name: String = n
  val city: String = c
  val country: String = co
  val email: String = e
  val products: Set[Product] = ps
  val customers: Set[Customer] = cs
  val accounts: Set[Account] = as
}
