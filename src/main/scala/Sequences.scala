import scala.collection.mutable

object Sequences extends App {

  val mySeq = Seq(1,2,4,5) //generally you want this
  val myMutableSeq = mutable.Seq(1,2,6,4) //or use this when you need to adjust content

  //so the below two really should not be needed
  var mySeqThatCanChangeToSomethingElse = Seq(1,2,6,7)
  var mutableAndChangableToSomethingElse = mutable.Seq(1,4,6,7,9)

  println(mySeq)
  println(myMutableSeq)
  println(mySeq.reverse)
  println(mySeq.mkString("*_*"))
  println(mySeq.tail) //everything without first element
  println(mySeq.head)
  println(mySeq.contains(9000))
  println(mySeq.contains(4))
  println(mySeq.indexOf(5))
  println(mySeq.indexOf(555)) //so -1 not found in Sequence
  println(mySeq.map(el => el+10)) //so we write a function on how to transform each element in our sequence
  val mappedSeq = mySeq.map(_*100) // shorthand for map (el => el*100)
  print(mappedSeq)
  //so map is one of the ways we work with imutable data, we just transform to another data
  //one of the advantages of this approach is that it works also on parallel machines (meaning clusters of machines)
  val filteredSeq = mySeq.filter(el => el >3)
  println(filteredSeq)
  mySeq.foreach(el => println(el+20)) //this will print each element with 20 added


  //Scala is not big on mutating but we can do it
  //generally we want to do it before finalizing this data into some immutable
  print(myMutableSeq :+ 100)
  val newMutable = myMutableSeq :+ 100
  println(newMutable)
  val newImmutable = mySeq :+ 2000
  println(newImmutable)
  newMutable.drop(6)
  println(newMutable)
  val anotherMutable = newMutable.drop(2) //drops from beginning
  println(anotherMutable)

  val bigSeq = (1 to 10).toVector //so range is something half ready given on demand, vector is something already made
  println(bigSeq)
  println(bigSeq.slice(3,6))
  val newSlice = bigSeq.slice(2,5)
  println(newSlice)
  println(newSlice.length)
  val by1000 = newSlice.map(_*1000)
  println(by1000)

  val a2 = Array("one", "two", "three", "four")
  val a3 = Array(100, "two", "three", "four") //try to avoid
  println(by1000(2))
  println(by1000.last)
  println(a2.slice(1,3).toSeq.toString)

  println(bigSeq.sum)
  println(bigSeq.length)
  println(bigSeq.sum/bigSeq.length.toDouble)






}
