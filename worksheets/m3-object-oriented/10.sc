/**
  * m3-object-oriented -> 10.sc
  */
abstract class Employee {
  val first: String
  val last: String
}

abstract class DepartmentEmployee extends Employee {
  private val secret = "Big Secret!"
  val department: String
  val departmentCode: String
  val numberOfStocks: Int

  override def toString: String =
    "[" + first + "," + last + "," + department + "," + numberOfStocks + "]"

}

class RnDEmployee(f: String, l: String) extends DepartmentEmployee {
  val first = f
  val last = l
  val department = "Research and Development"
  val departmentCode = "R&D"
  val numberOfStocks = 100
}

class MarketingEmployee(f: String, l: String) extends DepartmentEmployee {
  val first = f
  val last = l
  val department = "Marketing"
  val departmentCode = "MKT"
  val numberOfStocks = 85
}

val rnDEmployee = new RnDEmployee("Amy", "Jones")
val marketingEmployee = new MarketingEmployee("Bob", "Martin")

/* Composition Example */
abstract class Company {
  val name: String
  val numberOfEmployees: Int
  val employees: Set[Employee]
}

class PluralSight(n: String, es: Set[Employee]) extends Company {
  val name = n
  val numberOfEmployees = es.size
  val employees = es
}

val pluralSight = new PluralSight("PluralSight Inc", Set(rnDEmployee, marketingEmployee))
pluralSight.numberOfEmployees