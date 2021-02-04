import scala.io.StdIn.readLine

object MyApp extends App{
  println("My first Scala program!")
  print("Print has no new line ")
  print("it can be seen here")

  println("Continue:")
  println("Adding something more to my code")


  val myName = readLine("What is your name friend?") //readline will return Stringgs
  val favoriteFood = readLine(s"Hello there $myName what is your favorite food?")
  println(s"Cool I like $favoriteFood as well!" )
  val currentPrice = readLine(s"How much $favoriteFood is/are in stores right now?").toFloat
  println(s"Not bad I could buy some $favoriteFood for $currentPrice")
  val currentMoney = readLine(s"How much money do you have in your wallet?").toFloat
  //TODO find out how much we cab
  val maxPurchaseWeight = currentMoney / currentPrice
  println(s"Congratulations $myName! You can buy ${(maxPurchaseWeight*1000).round/1000.0} kilos of $favoriteFood right now")
}
