package com.suri.leetcode.hard;

/**
 You are given K eggs, and you have access to a building with N floors from 1 to N.

 Each egg is identical in function, and if an egg breaks, you cannot drop it again.

 You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.

 Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).

 Your goal is to know with certainty what the value of F is.

 What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?



 Example 1:

 Input: K = 1, N = 2
 Output: 2
 Explanation:
 Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 If it didn't break, then we know with certainty F = 2.
 Hence, we needed 2 moves in the worst case to know what F is with certainty.
 Example 2:

 Input: K = 2, N = 6
 Output: 3
 Example 3:

 Input: K = 3, N = 14
 Output: 4

 https://www.youtube.com/watch?v=oCu5QdeXR5w
 */
public class Soln_887_EggDroppingProblem {

  public static void main(String[] args) {

    int e = 2, f = 10;
    System.out.println(superEggDrop(e,f));

    System.out.println(superEggDrop(2,6));
    System.out.println(superEggDrop(3,14));
  }
  public static int superEggDrop(int e, int f) {
    if(f==0 ||f==1){
      return 1;
    }
    int eggFloor[][] = new int[e+1][f+1];

    for(int i=0;i<=e;i++){
      eggFloor[i][0]=0;
      eggFloor[i][1]=1;
    }

    for(int j=1;j<=f;j++){
      eggFloor[1][j]=j;
    }

    for(int i=2;i<=e;i++){

      for(int j=2;j<=f;j++){
        eggFloor[i][j]= Integer.MAX_VALUE;

        for(int k=1;k<=j;k++){
          int res = 1+Math.max(eggFloor[i-1][k-1], eggFloor[i][j-k]);
          if(res<eggFloor[i][j]){
            eggFloor[i][j] =res;
          }
        }
      }
    }
    return eggFloor[e][f];

  }
}