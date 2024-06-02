package functionalLoops:
  /** writing loops functionally */
  def factorial(num: Int): Int =
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc else go(n - 1, n * acc)
    go(num, 1)
  def factorialWithHof(num: Int): Int =
    (1 to num).map((i: Int) => i).reduce((l, r) => l * r)
