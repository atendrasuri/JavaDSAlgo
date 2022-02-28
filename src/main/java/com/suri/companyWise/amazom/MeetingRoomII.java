package com.suri.companyWise.amazom;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * Given, the starting and ending time of different meetings, what is the minimum number of conference rooms that will be enough to accommodate all of them.
 * I/p : Meeting I – 8:30 – 12:50
 * Meeting II – 10:15 – 11:30
 * Meeting III – 11:45 – 1:30
 * O/p : 2
 */
public class MeetingRoomII {
  public static void main(String[] args) {
    Interval interval[] = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
    System.out.println(new MeetingRoomII().minMeeingRooms(interval));

  }

  public int minMeeingRooms(Interval interval[]) {
    Arrays.sort(interval, (a, b) -> a.start - b.start);

    PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
    minHeap.add(interval[0]);
    for (int i = 1; i < interval.length; i++) {

      Interval current = interval[i];

      Interval earliest = minHeap.remove();

      if (current.start >= earliest.end) {
        earliest.end = current.end;
      } else {
        minHeap.add(current);
      }
      minHeap.add(earliest);
    }

    return minHeap.size();
  }
}

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
