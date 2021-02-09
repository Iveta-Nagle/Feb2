object LoopingSeq extends App {
  val persons = Seq ("Valdis", "Līga" , "Maija", "Ieva")
  println(persons(2))
  persons.foreach(println)
  for (person <- persons) {
    println(person.toUpperCase)
    println(person.length)
  }

  //how could we filter for only persons with short names of 4 or less
  val shortNames = for (p <- persons if p.length <=4) yield p
  shortNames.foreach(println)

  //we do not have to yield n we can yield something else
  val myStrings = for (n <- 1 to 20 if n % 3 == 0) yield s"My number $n"
  myStrings.foreach(println)
}
