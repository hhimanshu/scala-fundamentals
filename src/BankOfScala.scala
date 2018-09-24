import com.h2.entites._

object BankOfScala {
  def main(args: Array[String]): Unit = {

    println("Opening Bank")

    val bank = new Bank(name = "Bank of Scala", country = "New Zealand", city = "Auckland", email = Email("bank", "scala.com"))
    val customerIds = getCustomers map (c => bank.createNewCustomer(c._1, c._2, c._3, c._4))
    val depositProductIds = getDepositProducts map (p => bank.addNewDepositProduct(p._1, p._2, p._3))
    val lendingProductIds = getLendingProducts map (l => bank.addNewLendingProduct(l._2, l._3, l._4))

    /* logging */
    println(bank)
    println(customerIds)
    println(depositProductIds)
    println(lendingProductIds)


    /*
    Bank clerk opening the account.
    There is no money deposited in the account yet, so the accounts are not active
    */
    val depositAccounts = for {
      c <- customerIds
      p <- depositProductIds
    } yield bank.openDepositAccount(c, p, _: Dollars)

    /* Depositing money into the accounts */
    val random = new scala.util.Random(10000)
    val depositAccountIds = depositAccounts.map(account => account(Dollars(10000 + random.nextInt())))


    /* logging */
    println(depositAccounts)
    println(depositAccountIds)

    /*
     Open credit card accounts.
     The bank process has not finished the credit check, so, balance will be known later
    */
    val lendingAccounts = for {
      c <- customerIds
      p <- lendingProductIds
    } yield bank.openLendingAccount(c, p, _: Dollars)
    val lendingAccountIds = lendingAccounts.map(account => account(Dollars(random.nextInt())))

    /* logging */
    println(lendingAccounts)
    println(lendingAccountIds)


    /*
        val coreChecking = new CoreChecking(Dollars(1000), 0.025)
        val studentCheckings = new StudentCheckings(Dollars(0), 0.010)
        val rewardsSavings = new RewardsSavings(Dollars(10000), 0.10, 1)
        val creditCard = new CreditCard(99.00, 14.23, 20.00)
        val products = Set(coreChecking, studentCheckings, rewardsSavings, creditCard)

        val bobMartin = new Customer("Bob", "Martin", Email("bob", "martin.com"), LocalDate.of(1983, 8, 22))
        val bobCheckingAccount = new DepositsAccount(bobMartin, coreChecking, Dollars(10000))
        val bobSavingsAccount = new DepositsAccount(bobMartin, rewardsSavings, Dollars(20000))
        val bobCreditAccount = new LendingAccount(bobMartin, creditCard, Dollars(4500))
        val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)


        val bank = new Bank("Bank Of Scala", "Auckland", "New Zealand",
          Email("bank", "scala.com"), products, Set(bobMartin), accounts)


        println(bobCheckingAccount)

        //bobCheckingAccount.deposit(100)
        bobCheckingAccount deposit 100

        println(bobCheckingAccount)

        //bobCheckingAccount.withdraw(200)
        bobCheckingAccount withdraw 200

        println(bobCheckingAccount)
        */
  }

  /* ------------------- Data ------------------- */
  def getCustomers: Seq[(String, String, String, String)] = {
    Seq(
      ("Bob", "Martin", "bob@martin.com", "1976/11/25"),
      ("Amy", "Jones", "amy.jones@google.com", "1983/4/12"),
      ("Taylor", "Jackson", "taylor33@jackson.com", "1985/4/5")
    )
  }

  def getDepositProducts: Seq[(String, Int, Double)] = {
    Seq(
      ("CoreChecking", 1000, 0.025),
      ("StudentCheckings", 0, 0.010),
      ("RewardsSavings", 10000, 0.10),
    )
  }

  def getLendingProducts: Seq[(String, Double, Double, Double)] = {
    Seq(("CreditCard", 99.00, 14.23, 20.00))
  }
}
