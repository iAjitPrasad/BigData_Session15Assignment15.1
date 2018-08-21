/***To find the GCD of two numbers I have used the below logic:

If either 1st or 2nd number is 0, then other number is the Greatest Common Divisor.
Else call the GCD function again by sending 2nd number as 1st number and difference between 2 numbers as 2nd number.
This in turn checks for the If clause again.***/

class appGCD {

  /***Method to find the GCD of 2 numbers***/
  def gcd(a: Int, b: Int): Int = {
    if(b == 0) a else gcd(b, a%b)
  }

  /***Method to display list of choices to the user***/
  def OptionsList(): Unit = {
    println("\nGCD of 2 numbers")
    println("--------------------")

    println("\nSelect one of the following:")
    println("1. Compute GCD with command line argument")
    println("2. Compute GCD with standard input argument")

      println("\nEnter your choice (1 or 2): ")
    }
  }

  object appGCD {
    def main(args: Array[String]): Unit = {
      var wish =""

      /***Creating the instance of the appGCD class***/
      val aGCD  = new appGCD()

      do {
        /***Calling the method to display the list of options to the user***/
        aGCD.OptionsList()

        val choice = scala.io.StdIn.readLine()

        /***Find GCD from CommandLine Input Arguments (Get from the user)***/
        if (choice.toInt == 1) {
          val input1 = args(0).toInt
          val input2 = args(1).toInt

          println("\nCMD: GCD of ${input1} and ${input2} is : " + aGCD.gcd(input1, input2))
        }
        /***Find GCD from Standard Input Arguments (Get from the user)***/
        else if (choice.toInt == 2) {
          println("Enter the 1st number : ")
          val inp1 = scala.io.StdIn.readLine().toInt

          println("Enter the 2nd number : ")
          val inp2 = scala.io.StdIn.readLine().toInt

          println("STDIN: GCD of ${inp1} and ${inp2} is : " + aGCD.gcd(inp1, inp2))
        }
        else {
          println("Invalid choice!")
        }
        /***DoWhile loop conditional variable***/
        println("\nDo you wish to continue? (Y/N) : ")
        wish = scala.io.StdIn.readLine().toUpperCase

        println("--------------------------------------------------------------------------\n")
      }
      while (wish.equals("Y"))
    }
  }