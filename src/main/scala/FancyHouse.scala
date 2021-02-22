class FancyHouse extends House(houseName = "Fancy", heating = "Nuclear") {
  val paintings = scala.collection.mutable.ArrayBuffer("Leonardo", "Boticelli")

  def addNewPainting(paintName: String) = {
    paintings += paintName
    paintings.foreach(println)
  }
}
