package com.suri.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateShift {
    public static void main(String[] args) {

        //int [][] shifts = {{8, 10}, {10, 12}, {14, 19}, {15, 20}};

        int [][] shifts = {{15, 20}, {8, 10}, {10, 12}, {14, 19}};


        int [][] result = computeShift(shifts);
        for(int [] shift: result){
            System.out.println(shift[0]+" "+shift[1]);
        }


    }
    //[[8, 10], [10, 12], [14, 19], [15, 20]]
    public static int[][] computeShift(int [][] shifts){
        if(shifts.length==0){
            return new int[][]{{-1, -1}};
        }
        //result [8, 12], [14, 20]
        // short the shifts base on the checked-in time
        Arrays.sort(shifts, (a,b)-> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();

        for(int [] shift: shifts){
            if(result.size()==0){
                result.add(shift);
                continue;
            }
            else{
                int[] prevShift = result.get(result.size()-1);
                if(prevShift[1]>=shift[0]){
                    prevShift[1] = Math.max(prevShift[1], shift[1]);
                }else{
                    result.add(shift);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
