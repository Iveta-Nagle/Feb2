object SongExcercise extends App {

  val firstSong = new Song ("It's my life", "Jon Bovi",Seq("This ain't a song for the broken-hearted", "No silent prayer for faith-departed", "And I ain't gonna be just a face in the crowd","You're gonna hear my voice when I shout it out loud","It's my life","It's now or never","But I ain't gonna live forever","I just want to live while I'm alive","My heart is like an open highway","Like Frankie said,","I did it my way","I just want to live while I'm alive","It's my life"))

  firstSong.printSong()
  firstSong.singSong()
  firstSong.yellSong()


  println("-----------------------------------------")


  val secondSong = new Song ("Tā nogurt var tikai no svētkiem", "Prāta Vētra", Seq("Tā nogurt var tikai no svētkiem","No ne-par-ko runu plūdiem","Manu dvēseli glabājiet Kijevā","Zem Bulgakova raganu sūdiem","Vēlreiz, saki vēlreiz. Es klausos","Slapju sienu nav jākrauj zārdos","Lietas jāsauc īstajos vārdos","Lūk, pulkveža brieža iela","Ai, karamba un ļaudis tur tusē","Es stāvu tam visam pa vidu","Tomēr nezinu kurā pusē","Neko negribu teikt tāpat vien","Tomēr jāsaka, tik-tak pulkstenis skrien"))

  secondSong.printSong()
  secondSong.singSong()
  secondSong.yellSong(2)



}
