package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * hint:-
 *
 * 1  0 --> 1
 * 0  0 --> 0
 * 1  1 --> 1
 * 0  1---> 1
 */
public class Generate0And1with25And75Probability {
  // Random Function to that returns 0 or 1 with
  // equal probability
  static int rand50() {
    // rand() function will generate odd or even
    // number with equal probability. If rand()
    // generates odd number, the function will
    // return 1 else it will return 0.
    return (int) (10 * Math.random()) & 1;
  }

  // Random Function to that returns 1 with 75%
  // probability and 0 with 25% probability using
  // Bitwise OR
  static int rand75() {
    int x = rand50();
    int y = rand50();
    //int x = rand50() | rand50();
    System.out.println(x +" @@ "+y);
    return x | y;
  }

  // Driver code
  public static void main(String[] args) {
    // Initialize random number generator
    //srand(time(null));

    for (int i = 1; i <=2; i++) {
      rand75();
      System.out.print("");
    }

  }
}