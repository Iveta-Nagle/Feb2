import AnalyzePoetry.lines

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object AnalyzePoetry extends App {

  //with extends App we get access to command line arguments
  println("Command line arguments")
  args.foreach(println)

  val default_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/two_roads.txt"

  val real_path = if(args.size > 0) args(0) else default_path

  println(s"Will open file from $real_path")

  def getLinesFromFile(srcPath: String): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val lines = getLinesFromFile(real_path)
  println(s"We have ${lines.size} lines in our $real_path")

  //remember about 0 base indexing - so have to go minus 1
  lines.slice(340, 360).foreach(println)

  def getAuthors(lines: Array[String], startLine: Int, endLine: Int): Array[String] = {
    val inLines = lines.slice(startLine, endLine)


    //idea line which contains only Upper case characters will be the author line
    //we could do this with regular expressions but here today we will do it only with current tools

    val authors = inLines.filter(line => line.toUpperCase == line && (line.length > 0))
    authors
  }

  val authors = getAuthors(lines, 166,334)
  authors.foreach(println)



  val linesToProcess = lines.slice(166,334)

  def getPoemTitles(lines: Array[String], authors: Array[String]): Map[String, Array[String]] = {
    //in order to use toMap we need a sequence of pairs
    //val authorMap = authors.map( author => (author, ArrayBuffer(""))).toMap
    // for each author we map this author to pair of author and an empty ArrayBuffer with String inside
    val authorMap = authors.map( author => (author, ArrayBuffer[String]())).toMap


    var curAuthor = ""
    for (line <- lines) {
      //go through lines we set the curAuthor to this author
      //if we encounter title we add the title to curAuthor ArrayBuffer
      //if (authors.contains(line.stripMargin)) { // this might help to clean up empty spaces
        if (authors.contains(line)) {
        //println(s"Found author in $line")
          curAuthor = line // keep in mind that we have an exact match. If we did not have exact we need to find author
      } else if (line.length > 2 && line(line.length-2).isDigit && curAuthor != "") {
          //important that we check first of all if line is not empty
          //we got our title
          //println(s"Author $curAuthor and title $line")
          val titles = authorMap(curAuthor)
          titles += line
        }
    }
    val results = for ((author, titles) <- authorMap) yield (author, titles.toArray)
    results
  }

  val poemTitles = getPoemTitles(linesToProcess, authors)
  for ((key, value ) <- poemTitles) {
    println(s"Author $key")
    println("Poems")
    value.foreach(println)
    //so we split each line  on whitespace of any type
    value.foreach(title => title.split("\\s+").foreach(println))
  }

  def removeEmptyLines(lines: Array[String]): Array[String] = {
    lines.filter(_.length > 1) // for single comparison check
    // lines.filter(line => line.length > 1 ) // for more complicated checks
  }

  println("*"*40)


  val needle = "Amy Lowell"

  def findNeedle(lines: Array[String], needle: String): Int = {
    var lineNumber = -1 // our line indexes starts with 0
    for ((line, index) <- lines.zipWithIndex) {
      if (lineNumber == - 1 && line.toLowerCase.contains(needle.toLowerCase))
        lineNumber = index
    }
    lineNumber
  }

  val startLine = findNeedle(lines, needle)
  val endLine = findNeedle(lines, "bibliography")
  println(s"We will start at line: $startLine and end at $endLine")

  val noEmptyLines = removeEmptyLines(lines.slice(164,334))
  noEmptyLines.foreach(println)
  val noSubTitles = noEmptyLines.filter(line => !line.trim.startsWith("_"))
  println("*"*40)
  noSubTitles.foreach(println)

}
