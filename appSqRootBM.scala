/*** The Babylonian method for finding square roots involves dividing and averaging,
over and over, to obtain a more accurate solution with each repeat of the process.

•	Start with an arbitrary positive start value x (the closer to the root, the better).
  Initialize y = 1.
•	Do following until desired approximation is achieved.
  Get the next approximation for root using average of x and y
  Set y = n/x ***/

/***Dividing and Averaging Method to calculate square root of a number***/
object appSqRootBM {

  /***Function to return square root of a number using Babylonian Method***/
  def squareRootBM(num: Int): Float = {

    /***Arbitrary positive value x from the user***/
    var x: Float = num

    /***Initialize y***/
    var y: Float = 1

    /***e decides the accuracy level***/
    /***This is checked when we aren't sure if the number is a perfect square***/
    val e: Double = 0.000001

    /***Performs division and averaging until the accuracy level***/
    while(x - y > e) {
      x = (x + y) / 2
      y = num / x
    }
    x /***Returns the square root value***/
  }

  def main(args: Array[String]): Unit = {
    var wish = ""

    println("\nSquare Root using Babylonian Method")
    println("-------------------------------------")

    do {

      println("\nEnter the number: ")
      var input = scala.io.StdIn.readLine().toInt

      /***Calls the function to calculate Square Root using Babylonian Method***/
      println("\n_______________________________________________")
      println(s"Square Root of $input is ${squareRootBM(input)}")
      println("\n_______________________________________________")

      println("\n\n\nDo you wish to continue? (Y/N) : ")

      /***Do-While Loop for condition variable***/
      wish = scala.io.StdIn.readLine().toUpperCase

      println("--------------------------------------------------------------------------\n")
    }
    while (wish.equals("Y"))
  }
}