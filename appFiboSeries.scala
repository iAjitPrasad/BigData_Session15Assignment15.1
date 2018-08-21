/***To find the Fibonacci Series I have used two methods:

Using a Standard FOR Loop. This is achieved by the method LoopFibo(digits, nthdigit)
Using Recursion. This is achieved by the method recFibonacci(digits, nthdigit)

"@tailrec" annotation is used here to indicate that this is an optimized version of the function***/

import scala.annotation.tailrec

object appFiboSeries {

    def recFibonacci(n: Int, nth: Int): Unit = {
    var concat_result = "1"

    /***Method to find out the Fibonacci Series using Recursion***/
    @tailrec def fiboRecursive(n: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = n match {

      case 0 => prev
      case 1 => next
      case _ =>
        concat_result = concat_result + (prev + next)
        fiboRecursive(n - 1, next, next + prev)
    }

    fiboRecursive(n)
    get_nthchar_and_print(n, concat_result, nth)
  }

  /***Method to find out the Fibonacci Series using For Loop***/
  def LoopFibo(n: Int, nth: Int): Unit = {
    var concat_result = "1"

    if (n < 2) {
      println(n)
    }

    else {
      var result: BigInt = 0
      var n1: BigInt = 0
      var n2: BigInt = 1

      for (i <- 1 until n) {
        result = n1 + n2
        n1 = n2
        n2 = result
        concat_result = concat_result + result
      }

      get_nthchar_and_print(n, concat_result, nth)
      result
    }
  }

  /***Method to display Nth character in the Fibonacci Sequence***/
  def get_nthchar_and_print(n: Int, seq: String, nth: Int): Unit = {
      println(s"The Fibonacci Series ($n): " + seq)
      println(s"The digit at the place $nth of Fibo Sequence ($n): " + seq.charAt(nth -1).toChar)
  }

  def main(args: Array[String]): Unit = {
      var wish = ""

      println("Fibonacci Series")
      println("------------------------------------------------------------")

      do {
        println("Select one of the following:")
        println("1. Find Nth digit in the Fibonacci Series using For Loop")
        println("2. Find Nth digit in the Fibonacci Series using Recursion")

        println("Enter your choice (1 or 2): ")
        var choice = scala.io.StdIn.readLine()

        println("Enter the number of digits for Fibonacci Sequence: ")
        var digits: Int = scala.io.StdIn.readLine().toInt

        println("Enter the Nth digit to be found in the Fibonacci Sequence: ")
        var nthFind: Int = scala.io.StdIn.readLine().toInt

        println("--------------------------------------------------------------------------")


        if (choice.toInt == 1) {

          /***Call to method "LoopFibo" to find out the Fibonacci Series using For Loop***/
          println(s"Fibonacci Series using For Loop:")
          println("----------------------------------")
          LoopFibo(digits, nthFind)
        }

        /***Call to method "recFibonacci" to find out the Fibonacci Series using Recursion***/
        else if (choice.toInt == 2) {
          println(s"Fibonacci Series using Recursion:")
          println("-----------------------------------")
          recFibonacci(digits, nthFind)

        }
        else {
          println(s"Invalid Choice!")
        }

        println("Do you wish to continue? (Y/N) : ")

        /***Do-While Loop for condition variable***/
        wish = scala.io.StdIn.readLine().toUpperCase

        println("--------------------------------------------------------------------------\n")
      }
      while (wish.equals("Y"))
  }
}