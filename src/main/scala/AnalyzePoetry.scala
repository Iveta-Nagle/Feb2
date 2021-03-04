import AnalyzePoetry.lines
import Maps.args

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



  val lines = Utilities.getLinesFromFile(real_path)
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



  val startLine = Utilities.findNeedle(lines, needle)
  val endLine = Utilities.findNeedle(lines, "bibliography")
  println(s"We will start at line: $startLine and end at $endLine")

  val noEmptyLines = removeEmptyLines(lines.slice(164,334))
  noEmptyLines.foreach(println)
  val noSubTitles = noEmptyLines.filter(line => !line.trim.startsWith("_"))
  println("*"*40)
  noSubTitles.foreach(println)

  def extractUnderscoreText(s: String) :String = s match {
    case s"${head}_${target}_$tail" => s"HEAD: $head, TARGET: $target, TAIL: $tail"
    case _=> "no match"
  }

  val underscoreLines = lines.filter(line => extractUnderscoreText(line) != "no match")
  underscoreLines.foreach(println)

  //how about transforming data first? and filter later?
 val transformedText = lines.map(extractUnderscoreText)

  //transformedText.foreach(println)

  val transformedFilteredText = transformedText.filter(_ != "no match")
  transformedFilteredText.foreach(println)

  def getAuthorsTitles(lines: Array[String]): Unit = {
    var emptyCount = 0
    val authorCount = 3
    val titleCount = 4
    //idea we count empty lines and reset counter upon first non empty
    //if this non empty line has uppercase we can decide on whether that is author or title
    for (line <- lines) {
      if (line.trim.length == 0) emptyCount +=1
      else if (line.toUpperCase == line) {
        if (emptyCount == authorCount) println(s"AUTHOR: $line")
        else if (emptyCount == titleCount) println(s"TITLE: $line")
        emptyCount = 0
      } else emptyCount = 0
    }
  }

  getAuthorsTitles(lines)

  //start 340 end 4488

  //TODO get only poem text only use starting 340 and ending 4488
  //If feeling comfortable, add also capital author and title

  def getPoemText(lines: Array[String]): Array[String] = {
    lines.filter(line => !(line.toUpperCase == line) || line.length == 0)
  }

  val poemTextOnly = getPoemText(lines.slice(340,4488))
  poemTextOnly.foreach(println)

  val onlyPageNumbers = lines.filter(line => line.matches((""".+_\d+_""")))
  onlyPageNumbers.foreach(println)

  //now lets extract title and the page number exactly

  val regEx = """(.+)_(\d+)_""".r
  val poemPagesProcessed = for (line <- onlyPageNumbers) yield {
    val regEx(title, page) = line
    (title, page)
  }

  poemPagesProcessed.foreach(println)
 val poemPagesTrimmed = poemPagesProcessed.map(myTuple => (myTuple._1.trim, myTuple._2.trim))
  poemPagesTrimmed.foreach(println)

  val dedications = lines.filter(line => line.matches(".*\\(.+\\).*"))
  dedications.foreach(println)

  //we could get a more universal regex for phone extraction here
  //https://stackoverflow.com/questions/16699007/regular-expression-to-match-standard-10-digit-phone-number
  val phoneNumbers = lines.filter(line => line.matches(".*\\d{3}.{0,2}\\d{3}.{0,2}\\d{4}.*"))
  println(s"Got ${phoneNumbers.length} lines with phone numbers")
  phoneNumbers.foreach(println)
  val justPhoneRegEx = """.*(.\d{3}.{0,2}\d{3}.{0,2}\d{4}).*""".r
  val phones = phoneNumbers.map(line => {
    val justPhoneRegEx(phone) = line //a bit of strange syntax but it creates the results in phone from line given your regex
    phone
  })
  phones.foreach(println)

  //finding line number and the actual line which interest us

  val frostLines = lines.zipWithIndex.filter(pair => pair._1.matches(".*FROST.*"))
  frostLines.foreach(println)
  // could have chained the following after matches but for clarity storing the intermediate results
  val cleanFrost = frostLines.map(pair => (pair._1.trim, pair._2 +1))
  cleanFrost.foreach(println)

  //this only picks up emails in form of email00@domain.tld
  val simpleEmailRegEx = """.*\b(\w+@\w+.\w+).*""" //for matching it does not need the regex type just a string


  val emailLines = lines.filter(line => line.matches(simpleEmailRegEx))
  emailLines.foreach(println)

  val emailPattern = """\w+@\w+.\w+""".r //you'd use a more complex pattern for more complex emails

  //so we can go through lines one by one her we know line 3(index 2) has the 3 emails
  val emailMatches = emailPattern.findAllMatchIn(emailLines(2)).toArray //without toArray we get Iterator(lazy on demand)
  emailMatches.foreach(println)
  //how to get out all emails
  println("**** All emails **** ")
  //simplest would be to sticky all the filters lines back before getting the emails out

  val allEmails = emailPattern.findAllIn(emailLines.mkString("\n")).toArray
  allEmails.foreach(println)

  //we can use saveLines  utility method/function from our sibling Object in the same project
  Utilities.saveLines(allEmails, "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/e_mails.txt")
}
