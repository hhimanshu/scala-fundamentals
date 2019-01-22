import scala.annotation.tailrec

val n = 5

def sumR(n: Int): Int = {
  if(n == 1) 1
  else n + sumR(n-1)
}

sumR(n)


def sumTR(n: Int): Int = {
  @tailrec
  def go(currentNum: Int, totalSoFar: Int = 0): Int = {
    if(currentNum == 0) totalSoFar
    else go(currentNum - 1, totalSoFar + currentNum)
  }
  go(n)
}

sumTR(n)