import scala.io.StdIn.readLine

object WhileLoops extends App {
  println("Hello World!")

  var i = 0
  while (i < 5) {
    println("Alice did talk No.", i)
    println(s"Alice did talk No.$i")
    //cruical to change something with our iterator
    i += 1
  }

  println("I is ", i)
  //while lops are best used for uncertain looping, meaning we do not know how long the loop will last

  var userInput = ""
  while (!userInput.toLowerCase.startsWith("quit")
    && userInput != "q"
    && !userInput.toLowerCase.contains("exit")){
    println(s"You entered $userInput")
    userInput = readLine("Do you want to continue? enter 'q' to exit")
  }

  i = 0
  do {
    println("Will print no matter what", i)
    i += 50
  } while (i < 50)

  println("I is ", i)

  //we could write an infinitive loop but have

}
