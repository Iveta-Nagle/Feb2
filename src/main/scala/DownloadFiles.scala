object DownloadFiles extends App {

  val url = "https://www.gutenberg.org/ebooks/25880.txt.utf-8"

  import scala.io.Source
  val txtBuffer = Source.fromURL(url) //so network resource is used here and could take a while to read it

  //
  //
  val lines = txtBuffer.getLines.toArray
  println(txtBuffer.size) //this was 0 after we called getLines


  //printing first 20 lines
  println(lines.slice(0,20).foreach(println))
  val txt = lines.mkString("\n")

  val relative_save_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/poetry_1922.txt"

  def saveLines(lines: Array[String], destPath: String, sep: String = "\n") = {
    val txt = lines.mkString(sep)
    import java.io.{PrintWriter, File}
    val pw = new PrintWriter(new File(destPath))
    pw.write(txt)
    pw.close
  }

  saveLines(lines,relative_save_path)

}
