class MyList[T] {
  private var elems: List[T] = List.empty
  def add(e: T): Unit = elems = elems :+ e
  def print(): Unit = elems.foreach(println)
}

val l1 = new MyList[Int]
l1.add(1)
l1.add(2)
l1.print()

// subtyping works, no invariance issue?
abstract class Fruit {
  val name: String
  override def toString: String = name
}
class Apple extends Fruit {val name = "apple"}
class Banana extends Fruit {val name = "banana"}
val fruits = new MyList[Fruit]
val apple = new Apple
val banana = new Banana
fruits.add(apple)
fruits.add(banana)
fruits.print()

/// Scala in Depth. Chapter 6: The Type System
class ClassName
trait TraitName
object ObjectName

def foo(x: ClassName) = x // Simple Type
def bar(x: TraitName) = x // Refers to Trait
def baz(x: ObjectName.type) = x // Refers to Object's type