//in Scala objects define so called singleton objects
//in OOP terms this means only one UsingClasses exists


object UsingClasses extends App {
  val myHouse = new House ("Birzmali", "central") //creating new objects from regular classes I need new keyword
  println(myHouse)
  println(myHouse.age, myHouse.color, myHouse.isForSale, myHouse.style)
  val friendsHouse = new House ("Piejuras", "wood", hasGarage = true)
  friendsHouse.isForSale = true
  friendsHouse.color = "red"
  friendsHouse.heating = "gas"
 // println(friendsHouse.age, friendsHouse.color, friendsHouse.isForSale, friendsHouse.style)
  friendsHouse.prettyPrint()
  friendsHouse.showSecret()
  val coolSecret = myHouse.getSecret()
  println(coolSecret)
  println(myHouse.getMutSecret())
  myHouse.setMutSecret("New private info")
  println(myHouse.getMutSecret())
  println(myHouse.myAdd(3,100))

  val castle = new FancyHouse()
  castle.prettyPrint() //pretty print was inherited from house
  castle.addNewPainting("Van gog")
}
