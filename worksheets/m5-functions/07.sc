/* without repeated parameters */
def lengthOfStrings(strings: Seq[String]): Unit = strings foreach (s => println(s"$s -> ${s.length}"))
lengthOfStrings(Seq("a", "bb", "ccc"))

/* with repeated parameters */
def lengthOfStringsR(strings: String*): Unit = strings foreach (s => println(s"$s -> ${s.length}"))
lengthOfStringsR("a", "bb", "ccc", "dddd")


/* repeated parameters but caller has array */
def incrementBy1(nums: Int*) = nums map (_ + 1)

val arr = Array(1, 2, 3, 4, 5)
// incrementBy1(arr) // compilation failure
incrementBy1(arr: _*)