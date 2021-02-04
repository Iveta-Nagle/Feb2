println("Hello there Scala fans!")
//experimenting worksheet
val a = 5+6 //we are saying here that a should be of data type of whatever a+b produces
println(a)
println(math.pow(2,32))
var b = 10
//can't do b = b + 5
b = b + 5
println(a+b)
//Scala also have variables which we use when fixed/imutable values will not suffice
var myVar = 50
myVar = myVar + 30
println(myVar)
val result = a + b
val bigResult = myVar + math.pow(2,16)
println(result.getClass, bigResult.getClass)