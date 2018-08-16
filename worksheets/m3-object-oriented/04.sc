/**
  * m3-object-oriented -> 04.sc
  */
class Employee(val first: String, val last: String) {
  override def toString: String = first + " " + last
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin

/**
bobMartin.first
bobMartin.last
bobMartin.first = "Scary!"
*/