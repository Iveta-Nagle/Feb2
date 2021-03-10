import java.io.FileWriter

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object CookbookExercise extends App {

  def getLinesFromFile (src:String): Array[String] = {
    val bufferedSource = Source.fromFile(src)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val srcName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8.txt"
  val dstName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8-cleaned.txt"

  val cookBook_lines = getLinesFromFile(srcName)

  def findNeedle(lines: Array[String], needle: String): Int = {
    lines.indexWhere(line => line.toLowerCase.contains(needle.toLowerCase))
  }

  //getting recipe names from index to recipes in the end of the book

  val needle = "INDEX TO RECIPES"
  val startLine = findNeedle(cookBook_lines, needle)

  def getRecipeNames (lines: Array[String], startLine: Int, endLine: Int): Array[String] = {
    val onlyRecipeNames = lines.slice(startLine,endLine).filter(line => line.matches(""".+\w""")  || line.matches("""\s+"\s+\w.+""") || line.matches(""".+"""") )
    val recipes= onlyRecipeNames.map(line => line.toUpperCase)
    for (n<-0 until recipes.length-1 ) {
      if (recipes(n).matches("""\s+"\s+\w.+""")) {
        val replacement = recipes(n-1).split(" ")
        recipes(n) = recipes(n).replaceAll("""\s+"\s+""",replacement(0)+" ")
      }
    }
    recipes
  }

  val recipeNames = getRecipeNames(cookBook_lines, startLine,4324)

  def processSeq(mySeq: Seq[String], recipeNames: Array[String]): Map[String, Array[String]] = {
    val recipeMap = recipeNames.map( recipe => (recipe, ArrayBuffer[String]())).toMap
    var curRecipe = ""
    for (line <- mySeq) {
      if (recipeMap.contains(line)) {
        curRecipe = line
      } else if (curRecipe!="" && line.length > 2  && line.matches("""\s+\d.+""") || line.matches("""\s\s\s\s\w.+""")) {
        val ingredients = recipeMap(curRecipe)
        ingredients += line
      } else curRecipe == ""
    }
    val results = for ((recipe, ingredients) <- recipeMap if ingredients.nonEmpty) yield (recipe, ingredients.toArray)
    results
  }

  def saveSeq(destName:String, mySeq:Map[String, Array[String]], sep: String = "\n"): Unit = {
    val fw = new FileWriter(destName)
    for ((key, value ) <- mySeq) {
      fw.write(key + sep + sep)
      value.foreach(ingredient => fw.write(ingredient + sep))
      fw.write(sep+sep)
    }
    fw.close()
  }

  val filteredSeq = processSeq(cookBook_lines.slice(96,4076), recipeNames)
  saveSeq(dstName,filteredSeq)

  //Printing out results here
  for ((key, value ) <- filteredSeq) {
    println(key + "\n")
    value.foreach(ingredient => ingredient.split("\\n+").foreach(println))
    println("\n")
  }


}
