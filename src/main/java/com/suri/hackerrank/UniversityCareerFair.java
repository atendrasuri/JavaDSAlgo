package com.suri.hackerrank;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**

 */
public class UniversityCareerFair {


    public static void main(String[] args) {
      int[] arrival = {1,2,3,4,5,6,7};
      int[] duration = {2,2,5,2,3,2,2};
      System.out.println(maxEvents(arrival, duration));
//2
    }

    public static int maxEvents(int[] arrival, int[] departures){
      int[][] events = new int[arrival.length][2];
      for(int i=0;i<arrival.length;i++) {
        events[i] = new int[] {arrival[i], arrival[i] + departures[i]};
      }
      Arrays.sort(events, (a, b)->(a[1] - b[1]));
      Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
      int[] first = events[0];
      for(int i=1;i<events.length;i++) {
        int[] cur = events[i];
        if(cur[0] < first[1])
          minHeap.offer(cur);
        else {
          first[1] = events[i][1];
        }
      }
      return arrival.length - minHeap.size();
    }
  }
