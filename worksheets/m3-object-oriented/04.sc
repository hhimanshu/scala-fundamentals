/**
  * m3-object-oriented -> 04.sc
  */
class Employee(val first: String, val last: String) {
  override def toString: String = first + " " + last
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin

bobMartin.first
bobMartin.last

class Color(val value: String) // public val field
val c = new Color("red")
c.value

class Shape(var value: String) // public var field
val s = new Shape("circle")
s.value
s.value = "square"
s.value