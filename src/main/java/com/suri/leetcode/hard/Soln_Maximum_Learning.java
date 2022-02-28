package com.suri.leetcode.hard;

import java.util.List;

/*
You will be given a list of articles with their page lengths and intellectual value coefficients. Given a limit to the number of pages you can read in a day, determine the maximum intellectual value you can achieve during one day.
For example, your articles are of lengths articles = [2,2,3,4] and they are of intellectual value iv = [2,4,4,5]. If you can read p=15 pages in a day, what should you read? You have to read each article twice to gain value. Associating 2*articles[i] with iv[i], we can create the array associated = [[4,2], [4,4], [6,4], [8,5]]. The maximum combined length of articles read twice is 14 pages and there are two ways to get there: read articles[0], articles[1] and articles[2] for a total intellectual value of 2 + 4 + 4 = 10 or read articles[2] and articles[3] for a total of 4 + 5 = 9. Our maximal learning is 10 intellectual value points.
https://leetcode.com/discuss/interview-question/1063118/Akamai-or-Maximum-Learning
 */
public class Soln_Maximum_Learning {
    public static void main(String[] args) {

    }
    public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p) {

        int size = articles.size();
        int[] art = new int[size];
        int[] ivs = new int[size];

        for(int i=0;i<size;i++){
            art[i] = articles.get(i)*2;
            ivs[i] = iv.get(i);
        }
        return knapSackTopDownCode(ivs, art, p, size);
    }

    public static int knapSackTopDownCode(int[] val, int[] wt, int W, int n) {
        int mat[][] = new int [n+1][W+1];

        for(int i=0;i<n+1;i++) {
            for(int j=0;j<W+1;j++) {
                if(i==0 || j ==0)
                    mat[i][j] =0;

                else if(wt[i-1]<=j) {
                    mat[i][j] = Math.max(val[i-1]+ mat[i-1][j-wt[i-1]],
                            mat[i-1][j]);
                }
                else {
                    mat[i][j] = mat[i-1][j];
                }
            }
        }

        return mat[n][W];
    }
}
