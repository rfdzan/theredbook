package money:
  class CreditCard {
    def deposit(): Int =
      100
    // with side effect
    def charge(price: Int) =
      val deposit = 100
      deposit - price
  }
package withSideEffect:
  import whatIsBought.Coffee
  import money.CreditCard
  class Cafe {
    def buyCoffee(cc: CreditCard): Coffee =
      val cup = new Coffee()
      // side-effect.
      // This is difficult to test, how do we test cc.charge()?
      cc.charge(cup.price())
      cup
  }
package moreModular:
  import whatIsBought.Coffee
  import money.CreditCard
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
package whatIsBought:
  class Coffee {
    def price(): Int =
      10
  }
/** Functional solution*/
package functionalSolution:
  import whatIsBought.Coffee
  import money.CreditCard
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
