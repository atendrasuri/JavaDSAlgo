package com.suri.leetcode.medium;


import com.suri.common.Pair;

/*
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input :
str1 = "heap", str2 = "pea"
Output :
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.


Example 2:

Input :
str1 = "geeksforgeeks", str2 = "geeks"
Output :
Minimum Deletion = 8
Minimum Insertion = 0

https://leetcode.com/problems/delete-operation-for-two-strings/
https://leetcode.com/discuss/general-discussion/1274591/minimum-no-of-deletions-insertions-to-transform-1-string-into-another
https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 */
public class Soln_583_Minimum_Operation_MakeTwoStringsSame {

    public static void main(String[] args) {
        System.out.println(minOperation("heap", "pea"));
        System.out.println(minOperation("abc", "dbc"));
    }

    public static Pair<Integer, Integer> minOperation(String word1, String word2) {
        int lcs = lcs(word1, word2);
        int insertion = word1.length() - lcs;
        int deletion = word2.length() - lcs;
        return new Pair<>(insertion, deletion);

        /*
        int m = word1.length();
        int n = word2.length();
        return (m-lcs)+(n-lcs);
         */
    }

    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
