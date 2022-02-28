/*
package com.suri.companyWise.amazom;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Test123 {


    public static int M =4;
    public  static  int N=4;
    public static void main(String[] args) {

        int matrix[][] = {
                {1, 1, 1 ,1},
                {1, 0, 1 ,1},
                {1, 1, 1 ,1},
                {0, 1, 0 ,1}
        };

        System.out.println(totalCount(matrix, 1, 2, 1, 1, 3, 2));
    }


    public  static int totalCount(int matrix[][], int x, int y, int i1, int j1, int i2, int j2){

        int totalcount =0;
        totalcount+= N-1-x;
        totalcount+=x;
         totalcount+= M-1-y;
         totalcount+= y;

         if(x== i1){
            totalcount = totalcount-i1;
         }
         if(y==j1){
             totalcount = totalcount-(N-1-j1);
         }

        return totalcount;

    }

    public static int totalSteps(int matrix[][], int x, int y, int i1, int j1, int i2, int j2) {


        */
/*List<Pair<Integer, Integer>> blockerlist = new ArrayList<>();

        Pair pair1 = new ImmutablePair(i1, j1);
        Pair pair2 = new ImmutablePair(i2, j2);
        blockerlist.add(pair1);
        blockerlist.add(pair2);*//*


        int count = 0;
        for (int i = x; i < M; i++) {

            for (int j = y; j < N; j++) {

                if (!blockerlist.contains(matrix[i][j])) {
                    count += traverse(matrix, i, j, blockerlist);

                }
            }
        }
        return count;

    }




    private static int traverse(int matrix[][], int i, int j, List<Pair<Integer, Integer>> blocker) {

        // suppose M, N are matrix size and available as constant

        if (i < 0 || i > M || j < 0 || j > N) {
            return 0;
        }

      */
/*  if (isblocker(matrix, i, j, blocker)) {
            return 0;
        }*//*

        int count = 0;
        count += traverse(matrix, i - 1, j, blocker);
        count += traverse(matrix, i, j - 1, blocker);
        count += traverse(matrix, i + 1, j, blocker);
        count += traverse(matrix, i, j + 1, blocker);
        count += traverse(matrix, i - 1, j - 1, blocker);
        count += traverse(matrix, i + 1, j + 1, blocker);
        return count;
    }


   */
/* private static boolean isblocker(int matrix[][], int i, int j, List<Pair<Integer, Integer>> blocker) {

        //make pair of matrix of i, j
        if (blocker.contains()) {
            return true;
        }
        return false;
    }*//*




}
*/
