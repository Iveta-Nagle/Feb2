object RandonNums extends App {


    //TODO generate a sequence of 100 random 2 dice throws so and then calculate the average and print frequency of each throw
    val r = scala.util.Random
    r.setSeed(555)
    val myRandoms = for (i <- 1 to 10000000) yield r.nextInt(6) + 1 + r.nextInt(6) + 1 //so we want two dice throws - 100 of them
    println(myRandoms.slice(0,20))

  println(myRandoms.sum/myRandoms.length.toDouble)
  val myMin = myRandoms.min
  val myMax = myRandoms.max
  val frequencies = for (n <- myMin to myMax) yield myRandoms.filter(el => el == n).length
  println(frequencies)

}
