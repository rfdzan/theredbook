package TheCafe

class CreditCard {
  def deposit(): Int =
    100
  // with side effect
  def charge(price: Int) =
    val deposit = 100
    deposit - price
}
object withSideEffect {
  import whatIsBought.Coffee
  class Cafe {
    def buyCoffee(cc: CreditCard): Coffee =
      val cup = new Coffee()
      // side-effect.
      // This is difficult to test, how do we test cc.charge()?
      cc.charge(cup.price())
      cup
  }
}
object moreModular {
  import whatIsBought.Coffee
  class Payments {
    def charge(cc: CreditCard, price: Int): Int =
      val coffee = new Coffee();
      val cc = new CreditCard();
      cc.deposit() - coffee.price()

  }
  class modularCafe {
    def buyCoffee(cc: CreditCard, p: Payments): Coffee =
      val cup = new Coffee()
      p.charge(cc, cup.price())
      cup
  }
}
object whatIsBought {
  class Coffee {
    def price(): Int =
      10
  }
}

/** Functional solution */
object functionalSolution {
  import whatIsBought.Coffee
  case class Charge(cc: CreditCard, amount: Double) {
    def combine(other: Charge): Charge =
      if (cc == other.cc)
        Charge(cc, amount + other.amount)
      else
        throw new Exception("Cannot combine charges of different credit cards.")
  }

  class functionalCafe {
    def buyCoffee(cc: CreditCard): (Coffee, Charge) =
      val cup = new Coffee()
      (cup, Charge(cc, cup.price()))

    def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) =
      val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
      // unzip() iterates through the list, pops the first element of the first pair, pushing it into another List which will only contain this first elements.
      // coffees -> a list
      // charges -> via reduce() becomes a single value of type Double
      val (coffees, charges) = purchases.unzip()
      (coffees, charges.reduce((c1, c2) => c1.combine(c2)))

  }
}
package RunCafe:
  import withSideEffect.Cafe
  import whatIsBought.Coffee
  import moreModular.{modularCafe, Payments}
  import functionalSolution.functionalCafe
  def hasSideEffect: Coffee =
    val cafe = new Cafe()
    val cc = new CreditCard()
    cafe.buyCoffee(cc)

  def isMoreModular: Unit =
    val cafe = new modularCafe();
    cafe.buyCoffee(new CreditCard(), new Payments())

  def funcCafe =
    val cafe = new functionalCafe()
    val result = cafe.buyCoffees(new CreditCard(), 10)
