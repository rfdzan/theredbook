import scala.collection.mutable.ArrayBuffer
import functionalLoops.factorialWithHof
import MonomorphicFunc.formatResult
@main def hello(): Unit =
  val factorialHof = formatResult("Factorial", 5, factorialWithHof)
  println(factorialHof)
