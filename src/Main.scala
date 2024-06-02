import scala.collection.mutable.ArrayBuffer
import withSideEffect.Cafe
import whatIsBought.Coffee
import money.CreditCard
import moreModular.{modularCafe, Payments}
import functionalSolution.functionalCafe
@main def hello(): Unit =
  hasSideEffect
  isMoreModular
  functional

def hasSideEffect: Coffee = 
  val cafe = new Cafe()
  val cc = new CreditCard()
  cafe.buyCoffee(cc)

def isMoreModular: Unit = 
  val cafe = new modularCafe();
  cafe.buyCoffee(new CreditCard(), new Payments())

def functional =
  val cafe = new functionalCafe()
  val result = cafe.buyCoffees(new CreditCard(), 10)
