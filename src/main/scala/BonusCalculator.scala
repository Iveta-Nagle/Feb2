import scala.io.StdIn.readLine

object BonusCalculator extends App {

  val employee = readLine ("What is your name?")
  println(s"Nice to talk to you $employee")
  val years = readLine(s"For how many years you are working here, $employee?").toInt
  val wage = readLine(s"$employee, now we would need to know what is your monthly wage?").toDouble

  if (years < 2) {
    println("Unfortunately, you will not get the bonus as you are working here for less than 2 years.")
  } else {
    val bonus = (years - 2) * (0.15 * wage)
    println(s"Congratulations, $employee! With $years years experience you will get bonus $bonus" )
  }

}
