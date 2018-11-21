/* Implicits Parameter example - Motivation */
abstract class Product {
  val price: Double
}

case class PackagedItem(price: Double) extends Product
case class FreshProduce(price: Double) extends Product

case class Tax(rate: Double)
val salesTax = Tax(0.10)

def totalPrice(product: Product, tax: Tax): Double = product.price * (1 + tax.rate)

val coffeeBag = PackagedItem(39.99)
val bread = PackagedItem(3.99)
val avocado = FreshProduce(1.99)

totalPrice(coffeeBag, salesTax)
totalPrice(bread, salesTax)
