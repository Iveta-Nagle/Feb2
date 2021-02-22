class Song (tittle:String, author:String, lyrics: Seq[String]) {

  def printSong(): Unit = println(s"Tittle - $tittle, author - $author")

  println("Song is made")

  def singSong(nextLines: Int = -1): Unit = {
    if (nextLines== -1)
      lyrics.foreach(println)
    else
        lyrics.slice(0,nextLines).foreach(println)
  }

  def yellSong(nextLines: Int = -1): Unit = {
    if (nextLines== -1)
      lyrics.foreach(l => println(l.toString.toUpperCase))
        else
          lyrics.slice(0,nextLines).foreach(l => println(l.toString.toUpperCase))
  }


}
