import CubeTable.mySeq
import Sequences.myMutableSeq

import scala.collection.mutable
import scala.io.StdIn.readLine

object CubeTable extends App {
  //TODO write a programm that takes user input for starting and end values
  //then save cubes of those values in a Seq data type and then print cubes out
  val begVal = readLine("What is the starting value?").toInt
  println(s"Will print cubes starting $begVal")

  val endVal = readLine("What is the ending value?").toInt
  println(s"Will print cubes ending $endVal")

  val mySeq = begVal to endVal
  println(mySeq)
  val cubeSeq = mySeq.map(el => math.pow(el,3).toInt)
  println(cubeSeq)

  //val cubeSeq = for (n<- begVal to endVal) yield s"$n cube = ${math.pow(n,3)}"



}
