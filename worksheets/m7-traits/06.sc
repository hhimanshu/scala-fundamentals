abstract class NumberQ {
  def get(): Int

  def put(i: Int): Unit
}

class Q extends NumberQ {
  private var numbers: List[Int] = List.empty

  override def get() = {
    val toReturn = numbers.head
    numbers = numbers.tail
    toReturn
  }

  override def put(i: Int): Unit = {
    numbers = numbers :+ i
  }
}

val queue = new Q
queue.put(10)
queue.put(20)
queue.get() // 10
queue.get() // 20

