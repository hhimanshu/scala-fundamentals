/* No interpolator */
val color = "White"
val price = 10.23

print("The price for " + color + " poster is " + price)

/* String interpolator */
println(s"The price for the $color poster is $price")

/* String interpolator with Object properties */
class Poster(val width: Int, val height: Int, val color: String, val price: Double)
val p = new Poster(8, 11, "white", 10.23)

println(s"The price is ${p.price}")
println(s"The price of ${p.width}x${p.height} ${p.color} poster is ${p.price}")

/* Raw interpolator */
println("I treat escape literals (\\ \\ \\ -> print 3) differently")
println(raw"I * DO NOT * treat escape literals (\\ \\ \\ -> print 6) differently")

/* f-string interpolator */
println(math.E)
println(f"${math.E}%.5f")
