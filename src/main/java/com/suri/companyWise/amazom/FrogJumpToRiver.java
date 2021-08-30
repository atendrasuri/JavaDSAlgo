package com.suri.companyWise.amazom;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 12/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * <p>
 * Note:
 * <p>
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 * <p>
 * [0,1,3,5,6,8,12,17]
 * <p>
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * <p>
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * [0,1,2,3,4,8,9,11]
 * <p>
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 */
public class FrogJumpToRiver {
  public static void main(String[] args) {

    int stones[] = {0, 1, 3, 5, 6, 8, 12, 17};

    int stones1[] = {0, 1, 2, 3, 4, 8, 9, 11};

    System.out.println(canCross(stones));
    System.out.println(canCross(stones1));
  }

  public static boolean canCross(int[] stones) {

    for (int i = 3; i < stones.length; i++) {

      if (stones[i] > stones[i - 1] * 2) {
        return false;
      }
    }

    HashSet<Integer> stonePosition = new HashSet<>();
    for (int stone : stones) {
      stonePosition.add(stone);
    }
    int lastStones = stones[stones.length - 1];

    Stack<Integer> positions = new Stack<>();
    Stack<Integer> jumps = new Stack<>();

    positions.add(0);
    jumps.add(0);

    while (!positions.isEmpty()) {
      int position = positions.pop();

      int jumpDistance = jumps.pop();

      for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
        if (i <= 0) {
          continue;
        }
        int nextPosition = position + i;
        if (nextPosition == lastStones) {
          return true;
        } else if (stonePosition.contains(nextPosition)) {
          positions.add(nextPosition);
          jumps.add(i);
        }
      }

    }
    return false;

  }
}