import scala.io.StdIn.readLine

object FizzBuzzExercise extends App {
  //TOD print a sequence on a screen of the following type
  //1,2,3,4,FIZZ,6,Buzz,8,9,Fizz,11,....34, FizzBuzz
  //if divides by 5 print Fizz
  //if divides by 7 print Buzz
  //if divides by 5 and 7 print FizzBuzz
  //otherwise we print the number itself

  val number = readLine("Enter number until which we do FizzBuzz exercise").toInt
  for (i <- 1 to number) {
    if (i % 5 == 0 && i % 7 == 0) println("FizzBuzz")
    else if (i % 5 == 0) println("Fizz")
    else if (i % 7 == 0) println("Buzz")
    else println(i)
  }

}
