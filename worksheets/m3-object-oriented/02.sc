/**
  * m3-object-oriented -> 02.sc
  */
class Employee {
  var first: String = ""
  var last: String = ""
}

var bobMartin = new Employee
bobMartin.first = "Bob"
bobMartin.last = "Martin"

var taylorJackson = new Employee
taylorJackson.first = "Taylor"
taylorJackson.last = "Jackson"

bobMartin = taylorJackson