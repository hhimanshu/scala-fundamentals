import java.util.UUID

trait Db {
  private var contents: Map[String, String] = Map.empty

  protected def save(key: String, value: String): Unit = contents += (key -> value)

  def get(key: String): Option[String] = contents.get(key)
}


class Account(userId: String, accountId: String)

class Bank extends Db {
  def openAccount(userId: String): String = {
    val accountId = "A-" + UUID.randomUUID()
    save(userId, accountId)
    accountId
  }

  def getAccount(userId: String): Option[String] = get(userId)
}

val bank = new Bank
val bobUserId = "U-BOB-" + UUID.randomUUID()
val amyUserId = "U-AMY-" + UUID.randomUUID()

val bobAccountId = bank.openAccount(bobUserId)
val amyAccountId = bank.openAccount(amyUserId)

assert(bobAccountId == bank.getAccount(bobUserId).get, "Bob Account Id do not match")
assert(amyAccountId == bank.getAccount(amyAccountId).get, "Amy Account Id do not match")