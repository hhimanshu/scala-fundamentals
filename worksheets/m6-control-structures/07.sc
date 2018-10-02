def assertTrue(predicate: => Boolean): Boolean = predicate

assertTrue(12 > 10)
assertTrue(12 + 34 - 12 < 30)


/* code evaluated before being passed to function */
def assertTrueEval(predicate: Boolean,
                   ifTrue: String,
                   ifFalse: String): String = if (predicate) ifTrue else ifFalse

assertTrueEval(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)

/* code evaluated only when a condition matches */
def assertTrueByName(predicate: Boolean,
                     ifTrue: => String,
                     ifFalse: => String): String = if (predicate) ifTrue else ifFalse

assertTrueByName(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)
