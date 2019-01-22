def assertTrue(predicate: => Boolean): Boolean = predicate

assertTrue(12 > 10)
assertTrue(12 + 34 - 12 < 30)


/* code evaluated before being passed to function */
def ifEval(predicate: Boolean,
           ifTrue: String,
           ifFalse: String): String = if (predicate) ifTrue else ifFalse

ifEval(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)

/* code evaluated only when a condition matches */
def ifByName(predicate: Boolean,
             ifTrue: => String,
             ifFalse: => String): String = if (predicate) ifTrue else ifFalse

ifByName(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)
