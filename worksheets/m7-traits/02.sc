/** Using Traits as Type **/

trait Db {
  private var contents: Map[String, String] = Map.empty

  def save(key: String, value: String): Unit = contents += (key -> value)

  def get(key: String): Option[String] = contents.get(key)
}

class InMemoryDB extends Db

val repo: Db = new InMemoryDB

repo.save("a", "apple")
repo.save("b", "banana")

repo.get("a")