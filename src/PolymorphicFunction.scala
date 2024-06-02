package MonomorphicFunc:
  def formatResult(name: String, n: Int, f: Int => Int): String =
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))

package PolymorphicFunc:
  def findFirst[A](as: Array[A], p: A => Boolean) =
    val found = as.filter(p).toList
    println(found)

  def mainPolymorphicFunc = 
    val nameArr= Array("bob", "john", "clara")
    val keyword = "bob"

    val intArr = Array(1,2,3,4,5)
    val keyint = 3

    findFirst(nameArr, (i) => i == keyword)
    findFirst(intArr, (i) => i == keyint)
