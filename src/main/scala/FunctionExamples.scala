object FunctionExamples extends App {

  //we can use a function to encapsulate a set of actions
  //DRY principle! Do not repeat yourself
  def goEat(): Unit = {
    println("Go eat")
    println("Let's order food")
  }


  goEat()
  for (_ <- 1 to 5) goEat()
  def orderFood(dish: String): Unit = {
    println(s"I am ordering $dish")
    println(s"${dish.toUpperCase} should be pretty tasty")
  }

  orderFood("potatoes")
  orderFood("ice cream")
  val soup = "beet soup"
  orderFood(soup)

  def eat(foodList: Seq[String]): Unit = {
    println("Greetings!")
    println("Let's order some food!")
    for (food <- foodList) orderFood(food)
    println("Let's eat!")
    println("Let's leave and be happy")
  }

  val myFoods = Seq("snacks", "borsch", "mashed potatoes and gravy", "ice cream")

  eat(myFoods)

  eat(Seq("eggs over easy", "orange juice")) //can make sequences on the fly

  def add(a:Double, b:Double): Double = {
    println(a+b)
    a+b //in Scala last line in function is returned automatically
  }
  //now with return value our function results can be saved
  val addResult = add(3,6)
  println(addResult)
  val bigAdd = add(add(10,2), add(5,3))
  println(bigAdd)

  def mult(a:Double, b:Double): Double = a*b //even a short function works

  val multAddResult = mult(add(4,5), mult(2,10))
  println(multAddResult)

  def pow(x:Double=2, n:Double=3, isDebug:Boolean = false): Int = {
    //sometimes you just want a wrapper around an existing function
    //we can provide some extra validation, some extra logic
    val result = Math.pow(x,n).toInt
    if (isDebug) println("Debugging", Math.pow(x,n).toInt)
    result //last line is automatically returned
  }

  println(pow())

  println(pow(5,4,isDebug = true)) //for booleans good style would be to show the name of arguments

  def max(x: Int, y: Int): Int = if (x>y) x else y

  println(max(33,21))
  println(max(3,21))

  //generally functions should not be longer than one page of screen, a few lines is enough

  myFoods.foreach(println)
  myFoods.foreach(orderFood) //this is shorthand for fuller syntax below
  myFoods.foreach(food => orderFood(food))
  //so foreach requires function as parameter
  //food => orderFood(food) is an anonymous function with no name
  //in functional programming we often pass around functions, so it can be handy to have functions

  val numbers = Seq(1,3,4,6,9,5)
  numbers.foreach(num => println(pow(num)))
  numbers.foreach(num => println(10+num))

  def myFun(num: Int): Unit = println(10+num)
  numbers.foreach(myFun)

  //functional style we can map new values
  //so in map we provide a function on how to transform each element one by pne
  val newNumbers = numbers.map(num => num*10+50)
  newNumbers.foreach(println)
  println(newNumbers.mkString(","))
  var newWords = numbers.map(num => s"Number $num")
  println(newWords.mkString("."))

  var addNumbers = numbers.filter(num => num % 2 == 1)
  println(addNumbers.mkString(","))
  var sortedNumbers = numbers.sorted
  println(sortedNumbers.mkString(","))
  var sortedNumbersReversed = sortedNumbers.reverse
  println(sortedNumbersReversed.mkString(","))
}
