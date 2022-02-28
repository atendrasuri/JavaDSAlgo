package com.suri.leetcode.hard;


import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 Number of cells a queen can move with obstacles on the chessboard
 Consider a N X N chessboard with a Queen and K obstacles. The Queen cannot pass through obstacles. Given the position (x, y) of Queen, the task is to find the number of cells the queen can move.

 Input : N = 8, x = 4, y = 4,
 K = 0
 Output : 27

 Input : N = 8, x = 4, y = 4,
 K = 1, kx1 = 3, ky1 = 5
 Output : 24

 https://www.geeksforgeeks.org/number-cells-queen-can-move-obstacles-chessborad/

 */

public class Soln_NumberofCellsQueenMove {

    public static void main (String[] args) {
        int n = 8;
        int k = 1;
        int x = 4;
        int y = 4;
        int ox[] = {5};
        int oy[] ={3};
        System.out.println(""+total_steps(n, k, x, y, ox, oy));
    }

    private static <K, V> Map.Entry<K, V> newEntry(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static int total_steps(int n, int k, int x, int y, int ox[], int oy[]) {
        Map<Map.Entry<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = newEntry(ox[i], oy[i]);
            map.put(entry, 1);

        }
        int count = 0;
        count += queenMove(n, x + 1, y, 1, 0, map);
        count += queenMove(n, x + 1, y + 1, 1, 1, map);
        count += queenMove(n, x + 1, y - 1, 1, -1, map);
        count += queenMove(n, x, y + 1, 0, 1, map);
        count += queenMove(n, x, y - 1, 0, -1, map);
        count += queenMove(n, x - 1, y, -1, 0, map);
        count += queenMove(n, x - 1, y + 1, -1, 1, map);
        count += queenMove(n, x - 1, y - 1, -1, -1, map);
        return count;
    }

    public static int queenMove(int n, int x, int y, int xincrement, int yincrement, Map<Map.Entry<Integer, Integer>, Integer> map) {
        int ans = 0;
        while (isValidPosition(n, x, y, map)) {
            x = x + xincrement;
            y = y + yincrement;
            ans++;
        }
        return ans;
    }

    public static boolean isValidPosition(int n, int x, int y, Map<Map.Entry<Integer, Integer>, Integer> map) {
        Map.Entry<Integer, Integer> pair = newEntry(x, y);
        if (x >= 0 && x < n && y >= 0 && y < n && (!map.containsKey(pair))) {
            return true;
        }
        return false;

    }
}
