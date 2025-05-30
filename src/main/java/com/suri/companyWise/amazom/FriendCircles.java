package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 *
 *
 * http://www.goodtecher.com/union-find/
 */
public class FriendCircles {
  public static void main(String[] args) {

    int arr[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    System.out.println(findCircleNum(arr));


  }

  public static int findCircleNum(int[][] M) {
    if (M.length == 0 || M[0].length == 0) {
      return 0;
    }
    int m = M.length;
    int n = M[0].length;
    UnionFind unionFind = new UnionFind(m * n);
    unionFind.setCircleCount(m);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (M[i][j] == 1 && i != j) {
          unionFind.union(i, j);
        }
      }
    }

    return unionFind.getCircleCount();


  }
}

class UnionFind {


  private int parents[];
  private int circleCount;

  UnionFind(int n) {
    parents = new int[n];

    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

  }

  public int find(int x) {

    if (parents[x] == x) {
      return x;
    }
    return parents[x] = find(parents[x]);
  }

  public void union(int a, int b) {

    int groupA = find(a);
    int groupB = find(b);
    if (groupA != groupB) {
      parents[groupA] = groupB;
      circleCount--;
    }
  }

  public void setCircleCount(int circleCount) {
    this.circleCount = circleCount;
  }

  public int getCircleCount() {
    return this.circleCount;
  }

}