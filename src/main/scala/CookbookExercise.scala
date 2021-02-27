import scala.io.Source

object CookbookExercise extends App {

  def getLinesFromFile (src:String): Array[String] = {
    val bufferedSource = Source.fromFile(src)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val cookBook_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/13177-8.txt"
  val cookBook_lines = getLinesFromFile(cookBook_path)
  cookBook_lines.foreach(println)

}
