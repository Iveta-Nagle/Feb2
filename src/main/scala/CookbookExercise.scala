import java.io.FileWriter

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

  val srcName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8.txt"
  val dstName = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8-cleaned.txt"


  val cookBook_lines = getLinesFromFile(srcName)

  val needle = "INDEX TO RECIPES"
  val startLine = Utilities.findNeedle(cookBook_lines, needle)
  val onlyRecipeNames = cookBook_lines.slice(startLine,4324).filter(line => line.matches(""".+\w"""))
  val recipes= onlyRecipeNames.map(line => line.toUpperCase)

  def processSeq(mySeq:Seq[String], recipes:Array[String])= {

    val recipeMap = recipes.map( recipe => (recipe, ArrayBuffer[String]())).toMap
    var curRecipe = ""
    for (line <- mySeq) {
      if (recipeMap.contains(line)) {
        curRecipe = line
      } else if (line.length > 2  && line.matches("""\s+\d.+""")) {
        val ingredients = recipeMap(curRecipe)
        ingredients += line
      }
    }
    val results = for ((recipe, ingredients) <- recipeMap) yield (recipe, ingredients.toArray)
    results
  }

  def saveSeq(destName:String, mySeq:Map[String, Array[String]], sep: String = "\n") = {
    val fw = new FileWriter(dstName)
    for ((key, value ) <- mySeq) {
      fw.write(key + sep + sep)
      value.foreach(ingredient => fw.write(ingredient + sep))
      fw.write(sep)
    }
    fw.close()
  }

  val filteredSeq = processSeq(cookBook_lines.slice(96,4076), recipes)
  saveSeq(dstName,filteredSeq)
  for ((key, value ) <- filteredSeq) {
    println(s"Recipe $key")
    println("Ingredients")
    value.foreach(ingredient => ingredient.split("\\n+").foreach(println))
  }


}
