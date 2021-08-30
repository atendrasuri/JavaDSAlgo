package com.suri.companyWise.google;

import java.util.Arrays;
import java.util.List;

/**
 Your company is designing a dam to be built across a stream to create a small lake. To reduce materials cost, it will be made of one or more concrete walls with mud packed in between them. Determine the maximum height of the mud segments in the dam with the following restrictions:

 One unit width of the gap between walls will contain one segment of packed mud
 The height of mud in a segment cannot exceed 1 unit more than an adjacent wall or mud segment.
 Given the placement of a number of walls and their heights, determine the maximum height of a mud segment that can be built. If no mud segment can be built, return 0.
 For example, there are n = 4 walls at wallPositions = [1, 2, 4, 7] with wallHeights = [4, 6, 8, 11].
 There is no space between the first two walls.
 Between positions 2 and 4, there is one unit open for mud. Heights of the surrounding walls are 6 and 8, so the maximum height of mud is 6 + 1 = 7.
 Between positions 4 and 7 there are two units. The heights of surrounding walls are 8 and 11.
 The maximum height mud segment next to the wall of height 8 is 9.
 The maximum height mud next to a mud segment of height 9 and a wall of height 11 is 10.
 Overall, mud segment heights are 7, 9 and 10, and the maximum height is 10.
 Function Description
 **/

public class DesignADam {
    public static void main(String[] args) {

        List<Integer> wallPositions = Arrays.asList(1,3,7);
        List<Integer> wallHeights = Arrays.asList(4,3,3);
        System.out.println(maxHeight(wallPositions, wallHeights));

    }

    public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
        int n = wallPositions.size();
        int mud_max = 0;
        for (int i = 0; i < n-1; i++) {
            if (wallPositions.get(i) < (wallPositions.get(i + 1) - 1)) {
                // that means there is gap between two walls
                int heightDiff = Math.abs(wallHeights.get(i + 1) - wallHeights.get(i));
                int gapLen = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
                int localMax = 0;
                if (gapLen > heightDiff) {
                    int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i)) + 1;
                    int remainingGap = gapLen - heightDiff - 1;
                    localMax = low + remainingGap / 2;
                } else {
                    localMax = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gapLen;
                }
                mud_max = Math.max(mud_max, localMax);
            }
        }
        return mud_max;
    }
}
