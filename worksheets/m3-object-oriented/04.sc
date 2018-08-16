/**
  * m3-object-oriented -> 04.sc
  */
class Employee(first: String, last: String) {
  override def toString: String = first + " " + last
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin
