package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ManMovingNStepsInAMatrix {

  public static void main(String[] args) {

    int arr[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    System.out.println(probabilityOfAlive(0, 0, 3));
  }


  public static int probabilityOfAlive(int x, int y, int n) {

    if (x < 0 || x > (n - 1) || y < 0 || y > (n - 1) || n < 1) {
      return 0;
    }
    return probabilityOfAlive(x, y, n, 2);
  }

  public static int probabilityOfAlive(int x, int y, int n, int step) {
    if (0 == step) {
      return 1;
    }

    int probability = 1;
    if (x > 0) {
      probability += probabilityOfAlive(x - 1, y, n, step - 1);
    }
    if (x < (n - 1)) {
      probability += probabilityOfAlive(x + 1, y, n, step - 1);
    }
    if (y > 0) {
      probability += probabilityOfAlive(x, y - 1, n, step - 1);
    }
    if (y < (n - 1)) {
      probability += probabilityOfAlive(x, y + 1, n, step - 1);
    }
    return probability;
  }
}