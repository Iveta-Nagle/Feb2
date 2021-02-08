import scala.io.StdIn.readLine

object BonusCalculator extends App {

  val employee = readLine ("What is your name?")
  println(s"Nice to talk to you $employee")
  val tenure = readLine(s"For how many years you are working here, $employee?").toFloat
  val wage = readLine(s"$employee, now we would need to know what is your monthly wage?").toDouble
  val minYears = 2
  val bonus = (tenure.ceil - minYears) * (0.15 * wage)

  if (tenure < minYears) {
    println(s"Unfortunately, you will not get the bonus as you are working here for less than $minYears years.")
  } else {
    println(s"Congratulations, $employee! With $tenure years experience you will get bonus $bonus" )
  }

}
