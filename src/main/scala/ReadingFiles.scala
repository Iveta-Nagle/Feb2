import scala.io.Source

object ReadingFiles extends App {
  println("Reading files")
  val absolute_path = "/Users/ivetanagle/Downloads/TextforScala.txt"
  //  for (line <- Source.fromFile(absolute_path).getLines) {
  //    println(line)
  //  }
  //val lines = Source.fromFile(absolute_path).getLines.toArray
  //better get a reference to our file buffer(stream) and then close it properly when done
  val bufferedSource = Source.fromFile(absolute_path)
  val lines = bufferedSource.getLines.toArray
  bufferedSource.close //now file is properly closed

  //now we can work with file contents
  lines.foreach(println)
  //we split each line by words in this case by whitespace
  val lines_tokenized = lines.map(line => line.split(" "))
  lines_tokenized.foreach(line => {
    line.foreach(println); println("*" * 20)
  })

  println(System.getProperty("user.dir"))

  val relative_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/two_roads.txt"

  def getLinesFromFile(srcPath: String): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val poem_lines = getLinesFromFile(relative_path)
  poem_lines.foreach(println)

  //filtering
  //val and_Lines = poem_lines.filter(line => line.startsWith("And")) // longer syntax
  val and_Lines = poem_lines.filter(_.startsWith("And"))
  and_Lines.foreach(println)
  val and_text = and_Lines.mkString("\n") //one big string with new lines in between

  //Printwriter
  val relative_save_path = "/Users/ivetanagle/IdeaProjects/Feb2/src/resources/two_roads_cleaned.txt"
  import java.io.{PrintWriter, File}
  val pw = new PrintWriter(new File(relative_save_path))
  pw.write(and_text)
  pw.close //when writing it is especially important to close as early as possible

}