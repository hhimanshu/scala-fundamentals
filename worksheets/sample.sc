/**
  *
  */
{
  object Bank {
    def apply(name: String) = new Bank(name)
  }

  class Bank(name: String) {
    override def toString: String = this.name
  }

  val bankA = Bank("Bank A")
  bankA
}

// ------------------------------------------------------------------------------------------

/**
  *
  */
{
  object Bank {
    def apply(name: String, branchCode: Int) = new Bank(name, branchCode)
  }

  class Bank(name: String, branchCode: Int) {
    override def toString: String = s"The bank is $name with branchCode $branchCode"
  }

  val bankB = Bank("Bank B", 10001)
  bankB
}

