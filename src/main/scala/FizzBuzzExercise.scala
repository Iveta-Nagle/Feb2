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

  //we used a for loop to create a collection of values
  val mySeq = for {
    i <- 11 to 20
  } yield i
  mySeq.foreach(println)

  val myNumbers = (21 to 30).toIndexedSeq
  println(myNumbers(4))


  //indexes in programming start at 0
  println(mySeq(0))
  println(mySeq(3)) // this prints 14


  //very rarely used in Scala and not recommended and too wordy and more chance to mess up
  for (i <-0  until myNumbers.length) {
    println(myNumbers(i))
  }

  //if we need index in Scala we can use zipWithIndex which creates and number
  for ((value, index) <- myNumbers.zipWithIndex) {
    println(s"Index $index value: $value ")
  }

  //we can create a sequence of FizzBuzz items for future use
  val myFizzBuzz = for {
    i <- 1 to 40
  } yield if (i % 5 == 0 && i % 7 == 0) "FizzBuzz"
  else if (i % 5 == 0) "Fizz"
  else if (i % 7 == 0) "Buzz"
  else i.toString //best to keep all items same type to have less any which loose

  myFizzBuzz.foreach(println)

}
