package com.suri.companyWise.google;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/the-celebrity-problem/
n a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.

Examples:

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not
know anyone but everyone knows him

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
Output: No celebrity
Explanation: There is no celebrity.
 */
public class Soln_Find_the_Celebrity {
    public static void main(String[] args) {

    }

    int celebrity(int arr[][], int n)
    {
        // code here


        Stack<Integer> stack = new Stack<>();


        for(int i =0;i<n;i++){
            stack.push(i);
        }



        while(stack.size()>=2){
            int i = stack.pop();
            int j = stack.pop();


            if(arr[i][j]==1){

                // i knows j -> i is not celebraty
                stack.push(j);
            }else{
                stack.push(i);
            }


        }


        int pot = stack.pop();


        for(int i =0;i<n;i++){

            if(i!=pot){

                if(arr[i][pot]==0 ||arr[pot][i]==1){
                    return -1;
                }
            }

        }
        return pot;


    }
}
