case class Event(id: Int, location: String, dayOfWeek: String, sessionTimeInSeconds: Integer, source: String)

val e1 = Event(1, "US", "Sun", 10, "Twitter")
val e2 = Event(2, "China", "Mon", 15, "WeChat")
val e3 = Event(3, "New Zealand", "Sun", 30, "Twitter")
val e4 = Event(4, "US", "Tue", 5, "Facebook")
val e5 = Event(5, "US", "Thu", 24, "LinkedIn")
val e6 = Event(6, "US", "Sat", 60, "Facebook")

/* Thin Interface */
trait EventsInterface {
  def get(eventId: Int): Option[Event]

  def all: List[Event]
}

/* Rich Interface */
trait RichEventsInterface extends EventsInterface {
  def getUniqueLocations: Set[String] = all.map(_.location).toSet

  def getUniqueSources: Set[String] = all.map(_.source).toSet

  def getAverageSessionTimeInSeconds: Float = all.map(_.sessionTimeInSeconds.toInt).sum / all.size
}

class Events(val events: List[Event]) extends RichEventsInterface {

  override def get(eventId: Int) = events.find(_.id == eventId)

  override def all = events
}


val events = new Events(List(e1, e2, e3, e4, e5, e6))
events.get(1)
events.getUniqueLocations
events.getAverageSessionTimeInSeconds
