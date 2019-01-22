abstract class NumberQ {
  def get(): Int

  def put(i: Int): Unit
}

trait Add1 extends NumberQ {
  abstract override def put(i: Int): Unit = super.put(i + 1)
}

trait Multiply2 extends NumberQ {
  abstract override def put(i: Int): Unit = super.put(2 * i)
}

trait Power2 extends NumberQ {
  abstract override def put(i: Int): Unit = super.put(math.pow(i, 2).toInt)
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


class Add1Q extends Q with Add1

val aQ = new Add1Q
aQ.put(10)
aQ.put(20)
aQ.get() // 11
aQ.get() // 21

class Add1Mul2Pow2 extends Q with Add1 with Multiply2 with Power2
val amQ = new Add1Mul2Pow2
amQ.put(10)
amQ.put(20)
amQ.get() // 201
amQ.get() // 801


class Mul2Pow2Add1 extends Q with Multiply2 with Power2 with Add1
val mpaQ = new Mul2Pow2Add1
mpaQ.put(10)
mpaQ.put(20)
mpaQ.get() // 242
mpaQ.get() // 882
