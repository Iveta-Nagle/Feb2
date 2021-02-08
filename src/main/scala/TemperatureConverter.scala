import scala.io.StdIn.readLine

object TemperatureConverter extends App {


  val temperature = readLine("Enter temperature").toDouble
  val scale = readLine (s"Is $temperature in Fahrenheit or Celsius?")
  val convertedToFahrenheit = (temperature* 1.8) + 32
  val convertedToCelsius = (temperature-32) * 0.56

  if (scale.toLowerCase.equals("fahrenheit")) {
    println(s"$temperature degrees by Fahrenheit is $convertedToCelsius degrees in Celsius")
  } else if (scale.toLowerCase.equals("celsius")) {
    println(s"$temperature degrees by Celsius is $convertedToFahrenheit degrees in Fahrenheit")
  } else {
    println("Can't do conversion - you entered incorrect scale")
  }


}
