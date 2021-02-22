case class Person(name: String, age: Int, height: Double, weight: Double, var hairColor: String){
  def getBMI: Double = {
    val heightMeters = height/100
    weight / (heightMeters*heightMeters)
  }
}
//arguments are values by default
//case clases come with some methods already premade - such ar printing values
