package com.suri.leetcode.hard;

/*
Given string str that represents a number. The task is to find all possible ways to split the given string such that each segment is a prime number in the range of 1 to 106.
Examples:


Input: str = “3175”
Output:
[317, 5]
[31, 7, 5]
[3, 17, 5]
Explanation:
There can be 8 possible ways to split:
[3175]
[317, 5] – All primes
[31, 75]
[31, 7, 5] – All primes
[3, 175]
[3, 17, 5] – All primes
[3, 1, 75]
[3, 1, 7, 5]
Input: str = “11373”
Output:
[113, 73]
[113, 7, 3]
[11, 373]
[11, 37, 3]
[11, 3, 73]
[11, 3, 7, 3]
https://www.geeksforgeeks.org/find-all-possible-ways-to-split-the-given-string-into-primes/


 */

import java.util.ArrayList;
import java.util.List;

public class Soln_Find_all_possible_ways_to_Split_the_given_string_into_Primes {
    public static void main(String[] args) {

        String str = "3175";
        List<List<String>> results = findPrimeSplits(str);
        System.out.println(results);
        System.out.println("ways = "+results.size());


        List<List<Integer>> primeSplits = findPrimeSplit(str);

        // Print the results
        System.out.println("All possible prime splits:");
        for (List<Integer> split : primeSplits) {
            System.out.println(split);
        }


    }

    public static List<List<String>> findPrimeSplits(String str){
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        compute(str, 0, results, result);
        return results;
    }

    public static void compute(String str, int start, List<List<String>> results, List<String> result) {

        if (start == str.length()) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int end = start + 1; end <= str.length(); end++) {

            String substr = str.substring(start, end);
            if (substr.length() > 0 && !substr.startsWith("0")) {
                int num = Integer.parseInt(substr);
                if (isPrime(num)) {
                    result.add(substr);
                    compute(str, end, results, result);
                    result.remove(result.size() - 1);
                }
            }

        }
    }

    public static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        boolean isPrime= true;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }

    /************************************ Iterative approach ************/


    public static boolean[] generatePrimes(int max) {

        boolean isPrime[] = new boolean[max+1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(max); i++) {

            for (int j = i * i; j <= max; j += i) {
                if (isPrime[i]) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static List<List<Integer>> findPrimeSplit(String str){

        int n = str.length();

        List<List<Integer>>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>()); // Base case: empty split

        // Precompute primes up to 10^6
        boolean[] isPrime = generatePrimes(1000000);

        for(int i=1;i<=n;i++){
            dp[i] = new ArrayList<>();
            for(int j=0;j<i;j++){
                String substr = str.substring(j, i);
                if(substr.length()>0 && !substr.startsWith("0")){
                    int num = Integer.parseInt(substr);
                    if(num<=1000000 && isPrime(num)){
                        for(List<Integer> list: dp[j]){
                            List<Integer> newList = new ArrayList<>(list);
                            newList.add(num);
                            dp[i].add(newList);
                        }
                    }
                }
            }
        }
        return dp[n];
    }

}
