import scala.io.StdIn.readLine

object ForLoops extends App {
  //more commonly used in Scala
  //used when we know the number of cycles/loops/iterations to perform


  //i is a val fixed for each loop cycle
  //i is not available outside the loop
  for (i<- 0 to 5) {
    println("Alice talked for time", i)
  }

  for (i<- 0 until 5) {
    println("This time Bob talked for time", i)
  }

  //we can use for loops to loop over a collection of some sort
  val myNumbers = Seq(2,3,5,10,15,88,-55)
  for (n <- myNumbers) {
    println("My number is", n)
  }

  val myName = "Valdis"
  for (c <- myName) {
    println("Letter", c)
    println("My BIG letters", c.toString.capitalize) //because c is a character
  }

  //for single expressions can skip curly braces
  for (c <- myName) println("Letter", c)

  //foreach method instead of loop
  //in this case we want to print it
  myName.foreach(println)

  //we can make up instruction on what to do for each element
  myName.foreach(c => println("Your letter", c))

  //guards
  //print only the odd ones
  for (i <- 1 to 10 if i % 2 == 1) println(i)

  //for more complicated examples you can split the guards over the lines
  for (i <- 1 to 10
       if i % 2 == 1
       if i > 3
       if i < 8) {
    println(i)
  }

  val mySentence = readLine("Enter a sentence")
  val words = mySentence.split(" ")
  for (word <- words) {
    println(s"word $word is ${word.length} characters long")
  }
}
