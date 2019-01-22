/* Implicits Parameters example */
abstract class Product {
  val price: Double
}

case class PackagedItem(price: Double) extends Product
case class FreshProduce(price: Double) extends Product
case class Tax(rate: Double)

implicit val salesTax: Tax = Tax(0.10)
val freshProduceSalesTax: Tax = Tax(0.0)

def totalPrice(product: Product)(implicit tax: Tax): Double = product.price * (1 + tax.rate)

val coffeeBag = PackagedItem(39.99)
val bread = PackagedItem(3.99)
val avocado = FreshProduce(1.99)

totalPrice(coffeeBag)
totalPrice(bread)
totalPrice(avocado)(freshProduceSalesTax)
