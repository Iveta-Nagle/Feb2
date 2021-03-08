import ReadingFiles.and_text

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object CookbookExercise extends App {

  def getLinesFromFile (src:String): Array[String] = {
    val bufferedSource = Source.fromFile(src)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  def saveLines(lines: Array[String], destPath: String, sep: String = "\n") = {
    val txt = lines.mkString(sep)
    import java.io.{PrintWriter, File}
    val pw = new PrintWriter(new File(destPath))
    pw.write(txt)
    pw.close
  }



//  val relative_save_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8_cleaned.txt"
//  import java.io.{PrintWriter, File}
//  val pw = new PrintWriter(new File(relative_save_path))
//  pw.write(and_text)
//  pw.close

  val srcName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8.txt"
  val dstName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8-cleaned.txt"

  def openSource(fName:String) = {
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq
    filePointer.close()
    myLines
  }



  val cookBook_lines = getLinesFromFile(srcName)

  val needle = "INDEX TO RECIPES"
  val startLine = Utilities.findNeedle(cookBook_lines, needle)
  val onlyRecipeNames = cookBook_lines.slice(startLine,4324).filter(line => line.matches(""".+\w"""))
  val recipes= onlyRecipeNames.map(line => line.toUpperCase)
  recipes.foreach(println)



  def processSeq(mySeq:Seq[String], recipes:Array[String])= {

    val recipeMap = recipes.map( recipe => (recipe, ArrayBuffer[String]())).toMap
    var curRecipe = ""
    for (line <- mySeq) {
      if (recipeMap.contains(line)) {
        curRecipe = line
      } else if (line.length > 2  && line.matches("""\s+\d.+""")) {
        val ingredients = recipeMap(curRecipe)
        //ingredients += line
      }
    }
    val results = for ((recipe, ingredients) <- recipeMap) yield (recipe, ingredients.toArray)
    results
//    //iterative solution
//    //TODO filter by multiple lines meaning CAPITAL then possible Illustration then 4 spaces
//    val ingredients = mySeq.filter(line => line.startsWith("    ")) //TODO add titles possibly with regex
//    //TODO more filtering for Illustrations and of course false titles meaning titles which do not have ingredients following
//    recipes
  }


  val filteredSeq = processSeq(cookBook_lines.slice(96,4076), recipes)
  for ((key, value ) <- filteredSeq) {
    println(s"Recipe $key")
    println("Ingredients")
    value.foreach(println)
    value.foreach(ingredient => ingredient.split("\\n+").foreach(println))
  }

//  val recipeMap = recipes.map( recipe => (recipe, ArrayBuffer[String]())).toMap
//  for ((key, value ) <- recipeMap) {
//    println(s"R $key")
//    println("I")
//    value.foreach(println)
//    value.foreach(ingredient => ingredient.split("\\n+").foreach(println))
//  }

//  def saveSeq(destName:String, mySeq:Seq[String]) = {
//    println(s"Saving my Sequence to file $destName")
//    //    mySeq.foreach(println) //we are good up to here
//    val fw = new FileWriter(dstName)
//    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
//    fw.close()
//  }
//
//  //the actual program runs here, little tiny pipeline like a factory
//  val mySeq = openSource(srcName)
//  val filteredSeq = processSeq(mySeq)
//  saveSeq(dstName,filteredSeq)



}
