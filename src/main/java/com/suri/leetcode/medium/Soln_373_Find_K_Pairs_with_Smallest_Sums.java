package com.suri.leetcode.medium;

import com.suri.common.Pair;

import java.util.*;

/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
https://leetcode.com/problems/find-k-pairs-with-smallest-sums
https://www.youtube.com/watch?v=PiGYS7BbV_Q&ab_channel=codestorywithMIK

Algorithm
Create two integer variables m and n. Initialize them to size of nums1 and nums2 respectively.
Create a list ans to store the pairs with smallest sums that are to be returned as the answer.
Create a hash set visited to keep track of pairs that are seen. Please note that we used ordered_set in C++ in place of unordered_set because the unordered_set uses hash template to compute hashes for its entries and there is no hash specialization for pairs. Either we define the hash function of pairs or use ordered_set which is a little expensive as it adds log factor. We are using ordered_set here.
Initialize a min heap minHeap that takes a triplet of integers: the sum of the pair, the index in nums1 of the first element of the pair, and the index in nums2 of the second element of the pair.
Push the first element from the both the arrays in minHeap, i.e., we push nums1[0] + nums2[0], 0, 0. We also insert pair (0, 0) in visited.
Iterate till we get k pairs and minHeap is not empty:
Pop the top of minHeap and set i = top[1] and j = top[2].
Push pair (nums1[i], nums2[j]) in ans.
If i + 1 < m and pair (i + 1, j) is not in visited, we push a new pair nums1[i + 1] + nums2[j], i + 1, j into the heap.
If j + 1 < n and pair (i, j + 1) is not in visited, we push a new pair nums1[i] + nums2[j + 1], i, j + 1 into the heap.
Return ans.

Crucks of the problem is


for given (i, j) => {  next we have to select either (i+1, j) OR (i, j+1)};
 */
public class Soln_373_Find_K_Pairs_with_Smallest_Sums {
    public static void main(String[] args) {
        int[] nums1= {1,1,2};
        int[] nums2 = {1,2,3};

        System.out.println(kSmallestPairs1(nums1, nums2, 2));

    }

    // optimized solution
    public static List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0){
            return result;
        }

        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> minHeap = new PriorityQueue<>((a, b)-> a.key -b.key);

        minHeap.add(new Pair(nums1[0]+nums2[0], new Pair(0, 0)));
        visited.add(new Pair(0, 0));

        while(k-- > 0 && !minHeap.isEmpty()){

            Pair<Integer, Pair<Integer, Integer>> top = minHeap.remove();
            int i = top.value.key;
            int j = top.value.value;

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if(i+1< nums1.length && !visited.contains(new Pair<>(i+1, j))){
                minHeap.add(new Pair<>(nums1[i+1]+nums2[j], new Pair<>(i+1, j)));
                visited.add(new Pair<>(i+1, j));
            }

            if(j+1< nums2.length && !visited.contains(new Pair<>(i, j+1))){
                minHeap.add(new Pair<>(nums1[i]+nums2[j+1], new Pair<>(i, j+1)));
                visited.add(new Pair<>(i, j+1));
            }
        }
        return result;

    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();


        if(nums1.length==0 || nums2.length==0 || k==0){
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> (a[0]+a[1])- (b[0]+b[1]));


        for(int i=0;i<nums1.length; i++){
            for(int j=0;j<nums2.length; j++){
                minHeap.add(new int[]{nums1[i], nums2[j]});
            }
        }

        while(!minHeap.isEmpty() && result.size()<k){
            int[] pair = minHeap.remove();
            List<Integer> ls = new ArrayList<>();
            ls.add(pair[0]);
            ls.add(pair[1]);
            result.add(ls);
        }
        return result;

    }




}
