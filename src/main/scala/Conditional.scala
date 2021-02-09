import scala.io.StdIn.readLine

object Conditional extends App {
  val myInput = readLine("Enter a number").toInt
  if (myInput > 20) {
    println("Your number is over 20", myInput)
  }

  //if else statement
  if (myInput > 10) {
    println("Your number is over 10!", myInput)
  } else {
    println("Your number is 10 or less")
  }

  if (myInput > 5) {
    println("oh yournumber is over 5!", myInput)
  } else if (myInput < 5) {
    println("oh your number is over 5!", myInput)
  } else {
    println("oh your number must be 5!", myInput)
  }

  println(s"This always prints: Your number was $myInput")

  val myResult = if (myInput > 5) "Over 5" else "5 or less"
  //if statements return values

  println(myResult)

}
