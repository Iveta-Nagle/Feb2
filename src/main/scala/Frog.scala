class Animal(val hasVertebrae: Boolean = true) {
  def scratchBack = s"scratches"
} //empty class

//in Scala we can extend single class or trait. Then we can add additional traits only with WITH
class Frog extends Animal with Philosophical with HasLegs{
  override def toString: String = "greenie"

}

trait HasLegs {
  var legCount = 4
  def jump (howFar: Double) = s"Print jumps on all $legCount legs $howFar meters far"
}