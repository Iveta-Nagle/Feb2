import scala.io.StdIn.readLine

object AgeCalculator extends App{
  println("This program will calculate the year when you will be 100")
  //TODO ask for person's name
  //TODO ask for person's age
  //TODO say when person will get 100
  val personName = readLine("What is your name?")
  val personAge = readLine(s"Nice to meet you $personName. Can you tell your age as well?").toInt
  println(s"$personName, you have ${100-personAge} years left until you will be 100")

}
