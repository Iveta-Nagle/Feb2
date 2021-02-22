object PlainObject {
  val myValue = 42
  val myName = "Valdis"

  def myMethod(): Unit = {
    println(s"$myName likes $myValue")
  }

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    myMethod()
  }

}
