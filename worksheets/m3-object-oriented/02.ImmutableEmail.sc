/**
  * todo: 1. Describe class structure
  * todo: 2. Show without toString first (show different memory address)
  * todo: 3. add toString method
  * todo: 4. Describe the mutation behavior
  */
class Email() {
  var from: String = ""
  var to: String = ""
  var subject: String = ""
  var body: String = ""

  /*override def toString: String = s"from: $from\n" +
    s"to:${to}\n" +
    s"subject:$subject\n" +
    s"body:$body\n"*/
}

var bobToRob = new Email
bobToRob.from = "bob@bob.com"
bobToRob.to = "rob@rob.com"
bobToRob.subject = "Hello!"
bobToRob.body = "Call me for movie recommendations!"
bobToRob

var amyToAlice = new Email
amyToAlice.from = "amy@amy.com"
amyToAlice.to = "alice@alice.com"
amyToAlice.subject = "Dinner!"
amyToAlice.body = "Let's meet at 8PM?"
amyToAlice
