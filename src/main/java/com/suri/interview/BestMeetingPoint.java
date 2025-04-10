package com.suri.interview;

import java.util.*;

/**

        You are given a 2D grid of values 0 or 1. Find a point in the grid from which the sum of the distances of each 1 is the minimum. The distance between two points (p1, p2) is calculated using the formula

        |p2.x - p1.x| +  |p2.y - p1.y|

        where |x| is the absolute value of x

        Input

        First line contains an integer T which is the number of test cases. Each case consists of N which signifies the number of 1s in the grid for that particular case followed by N space separated integers x,y which are the coordinates of the point in the grid whose value is 1.

        Output

        For each test case, print the value of minimum distance and number of points with minimum distance space separated.

        Constraints

        1 <= T <= 100
        1 <= N <= 50
        0 <= x,y <= 50

        1
        3
        0 0
        0 4
        2 2

        Sample Output

        6 1

        Explanation

        The grid formed from the input is as shown below.

        1 - 0 - 0 - 0 - 1
        |   |   |   |   |
        0 - 0 - 0 - 0 - 0
        |   |   |   |   |
        0 - 0 - 1 - 0 - 0

 **/
public class BestMeetingPoint {
  public static void main(String[] args) {
    BestMeetingPoint bestMeetingPoint = new BestMeetingPoint();

    int grid[][] = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};



    System.out.println(bestMeetingPoint.minTotalDistance(grid));

    System.out.println(bestMeetingPoint.minTotalDistance1(grid));

  }


  public int minTotalDistance(int[][] grid) {
    int minDistance = Integer.MAX_VALUE;
    Map<Integer,Integer> count = new HashMap<>();
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        int distance = search(grid, row, col);
        if(count.containsKey(distance)){
          count.put(distance,count.get(distance)+1);
        }
        else{
          count.put(distance,1);
        }
        minDistance = Math.min(distance, minDistance);
      }
    }
    int res=0;
    for(int key:count.keySet()){
      if(key==minDistance){
        res = count.get(key);
      }
    }
    System.out.println("number of such point "+res);
    return minDistance;
  }

  private int search(int[][] grid, int row, int col) {
    Queue<Point> q = new LinkedList<>();
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    q.add(new Point(row, col, 0));
    int totalDistance = 0;
    while (!q.isEmpty()) {
      Point point = q.poll();
      int r = point.row;
      int c = point.col;
      int d = point.distance;
      if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c]) {
        continue;
      }
      if (grid[r][c] == 1) {
        totalDistance += d;
      }
      visited[r][c] = true;
      q.add(new Point(r + 1, c, d + 1));
      q.add(new Point(r - 1, c, d + 1));
      q.add(new Point(r, c + 1, d + 1));
      q.add(new Point(r, c - 1, d + 1));
    }
    return totalDistance;
  }

  public class Point {
    int row;
    int col;
    int distance;
    public Point(int row, int col, int distance) {
      this.row = row;
      this.col = col;
      this.distance = distance;
    }
  }


  public int minTotalDistance1(int[][] grid) {
    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          rows.add(row);
          cols.add(col);
        }
      }
    }
    int row = rows.get(rows.size() / 2);
    Collections.sort(cols);
    int col = cols.get(cols.size() / 2);
    return minDistance1D(rows, row) + minDistance1D(cols, col);
  }

  private int minDistance1D(List<Integer> points, int origin) {
    int distance = 0;
    for (int point : points) {
      distance += Math.abs(point - origin);
    }
    return distance;
  }
}