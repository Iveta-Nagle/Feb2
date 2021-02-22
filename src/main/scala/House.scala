class House (houseName: String, var heating: String, var hasGarage: Boolean = false) {
  //so bluepring for creating object instances
  //public properties are by default
  val style = "gothic"
  var isForSale = false
  var age = 25
  var color = "green"
  //we can keep information private
  //info hiding is
  private val mySecret = "my secret"
  private var mutableSecret = "mutable secret"
  println("New house created!") //all the code within the clase is execute with run when new object is created with blueprint
  //in effect this is the constructor for new object
  //all functions are methods because they are in different classes
  def prettyPrint(): Unit = {
    println(s"House name: $houseName, heating: $heating, style:$style, is for sale? - $isForSale, color = $color, age = $age")
    println(s"Has garage: $hasGarage")
  }
  def showSecret(): Unit = println(s"My secret is $mySecret")
  def getSecret(): String = {
    //he
    mySecret
  }
  def getMutSecret(): String = mutableSecret
  def setMutSecret(txt: String): String = {
    mutableSecret = sanitizer(txt)
    "Success"
  }

  //I could have a public method for just passing in values/arguments and returning a result
  def myAdd(a: Int, b: Int): Int = a+b
  //private methods are for internal use only
  private def sanitizer(txt: String): String = {
    txt.toLowerCase()
  }
  println("New object creation is finished")
}
