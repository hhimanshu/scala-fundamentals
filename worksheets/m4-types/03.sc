/* Methods as operators */
val i1 = 10
val i2 = 30

val sum = i1 + i2
val anotherWaySum = i1.+(i2)

val multiply = i1 * i2
val divide = i2 / i1

val s = "Hello World!"
s indexOf 'o'
s indexOf('o', 5)

/* Prefix operators */
val negative = -100

/* Postfix Operators */
val toLong = 100 toLong

/* Create your own Prefix operator */
class Text(val string: String) {
  def unary_! = new Text(string + "!!")

  override def toString: String = string
}

val text = new Text("wow")
!text

text toString // example of Postfix operator