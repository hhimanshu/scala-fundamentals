package main.scala.com.h2.services

import main.scala.com.h2.entities.Dollars

object Currency {
  // https://api.exchangeratesapi.io/latest?base=NZD
  private val forexRates: Map[String, Double] = Map(
    "CAD" -> 0.9033746928,
    "USD" -> 0.6845891027,
    "EUR" -> 0.5994125757,
    "SGD" -> 0.9395792124,
    "INR" -> 48.9420368039,
    "NZD" -> 1.0,
  )

  /**
    * @param money: example? "100 USD", "20 EUR"
    * @return
    */
  implicit def stringToCurrency(money: String): Currency = {
    val Array(value: String, code: String) = money.split("\\s")
    val requestedAmount: Double = value.toDouble
    val currencyFactor: Double = forexRates(code)
    val totalCost: Int = (requestedAmount / currencyFactor).toInt

    println(s"Cost of converting $requestedAmount $code -> $totalCost NZD")
    Currency(code, value.toDouble, Dollars(totalCost))
  }
}

case class Currency(code: String, amount: Double, costInDollars: Dollars)