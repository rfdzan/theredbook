package MonomorphicFunc:
  def formatResult(name: String, n: Int, f: Int => Int): String =
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
