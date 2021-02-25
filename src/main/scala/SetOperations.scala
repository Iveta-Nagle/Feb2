import scala.collection.SortedSet

object SetOperations extends App {
  //sets provide constant(quick) 0(1) time lookup for item existance in the set
  println("Set operations")
  val r = new scala.util.Random(100) //100 is the seed for our pseido random generator
  //we need to initialize our random numb generator
  val mySet = Set (1,2,3,5,2,8,9,6)
  println(mySet)
  //Sets have only unique values
  val randomNums = (1 to 30).map (_ => r.nextInt(20))
  println(randomNums)
  val uniqueNums = randomNums.toSet
  println(uniqueNums)
  val sortedUniques = uniqueNums.toSeq.sorted
  println(sortedUniques)

  //here without the original Random(100) we will get trully random numb
  val someNum = scala.util.Random.nextInt(50)

  //if we want to add values to our set, we need to use Mutable set

  //going from immutable to mutable set
  val mutableSet = collection.mutable.Set.from(mySet)
  println(mutableSet)
  mutableSet.add(12)
  mutableSet.add(12)
  mutableSet.add(15)
  mutableSet.add(-15)

  //we can add more elements
  mutableSet ++= Set (33,66,2,1,5,-15)
  println(mutableSet)
  println(mutableSet.contains(5)) //very quick lookup
  //instead of contains we can use array seq like syntax
  println(mutableSet(1), mutableSet(5555))

  println(mutableSet)
  mutableSet.clear() //set should be empty now
  println(mutableSet)

  val fruit = Set("apple", "peach", "banana")
  println(fruit("mango"), fruit("apple"))
  val myNumbers = for (n <- 1 to 10) yield n
  val num1to10 = myNumbers.toSeq
  println(num1to10)
  val first6 = myNumbers.slice(0,6).toSeq
  println(first6)
  val last6 = myNumbers.slice(4,10).toSeq

 //Set intersection
//  val commonNums = first6 & last6
//  println(commonNums)
//
//  //Set union (everything)
  //Union is sort of similar to ++
//  val unionNums = first6 | last6
//  println(unionNums)
//
//  //Set A - set B
//  val firstDiff = first6 &- last6
//  println(firstDiff)

  //val bigIntersection= first6 & last6 & mySet
  //val bigUnion = first6 | last6 | mySet



  //we can iterate/loop over Set just like map or Sequence
//  for(item <- bigUnion) {
//    println(item)
//  }

  //we can get sorted set, but in general if we want something sorted, we should use sequence
 // val orderedSet = SortedSet.from(bigUnion)


}
