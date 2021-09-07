package com.suri.leetcode.medium;

import java.util.*;

/**
 https://leetcode.com/problems/task-scheduler/

 https://www.youtube.com/watch?v=tGw5GbDekTU&ab_channel=KnowledgeCenter
 Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

 However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

 Return the least number of units of times that the CPU will take to finish all the given tasks.

 Example 1:

 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation:
 A -> B -> idle -> A -> B -> idle -> A -> B
 There is at least 2 units of time between any two same tasks.
 Example 2:

 Input: tasks = ["A","A","A","B","B","B"], n = 0
 Output: 6
 Explanation: On this case any permutation of size 6 would work since n = 0.
 ["A","A","A","B","B","B"]
 ["A","B","A","B","A","B"]
 ["B","B","B","A","A","A"]
 ...
 And so on.
 Example 3:

 Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 Output: 16
 Explanation:
 One possible solution is
 A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A


 Constraints:

 1 <= task.length <= 104
 tasks[i] is upper-case English letter.
 The integer n is in the range [0, 100].
 */

public class Sol_621_TaskScheduler {
    public static void main(String[] args) {

        char [] arr = {'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(arr,n));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        maxHeap.addAll(map.values());

        int cycles =0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            //till the interval no same task should come
            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }
            //decrement the frequency and put it back to maxheap
            for(int i :temp){
                if(--i>0){
                    maxHeap.add(i);
                }
            }
            cycles+= maxHeap.isEmpty()?temp.size():n+1;
        }
        return cycles;
    }
}
