import scala.io.StdIn.readLine

object TemperatureTester extends App {

   val temperature = readLine("Enter your temperature").toDouble

   if (temperature > 37) {
      println("You have high temperature, suggesting to call to your doctor")
   } else if (temperature < 35) {
      println("Wow, you have low temperature - seems you are being too cold")
   } else {
      println("Everything is great! :) ")
   }


}
