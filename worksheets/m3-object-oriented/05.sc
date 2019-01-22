/**
  * m3-object-oriented -> 05.sc
  */
class Employee(f: String, l: String, s: Int) {
  private val first: String = f
  private val last: String = l
  private var stocks: Int = s

  def getFirst = first
  def getLast = last
  def getStocks = stocks

  def awardMoreStocks(numberOfStocks: Int): Unit = stocks += numberOfStocks

  override def toString: String = first + " " + last + " " + stocks
}

val bobMartin = new Employee("Bob", "Martin", 10)
bobMartin.getFirst
bobMartin.getLast
bobMartin.getStocks

bobMartin.awardMoreStocks(15)
bobMartin.getStocks
