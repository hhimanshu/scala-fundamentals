/**
  * m3-object-oriented -> 07.sc
  */
object MyApplication {
  def main(args: Array[String]): Unit = {
    println("I am entry point to the application")
    args.foreach(println)
  }
}
MyApplication.main(Array("hello", "world!"))