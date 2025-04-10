package test;





/*

Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15},{11, 16}, {5, 6}, {4, 23}}
Output: Following are conflicting intervals
[3,7] Conflicts with [1,5]
[2,6] Conflicts with [1,5]
[4,23] Conflicts with [1,5]


{1, 5}, {10 , 15} , {5, 6}

endTime = 5


{3, 7}, {2, 6}


heap { 1, 5}, {10, 15}







 */


import com.suri.common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestApril7 {

    public static void main(String[] args) {

        int[][] appointments = { {1, 5}, {3, 7}, {2, 6}, {10, 15}, {11, 16}, {5, 6}, {4, 23}};

        List<int[]> result = findConflictingIntervals(appointments);

        for(int[] res: result){
            System.out.println(res[0]+" "+ res[1]);
        }
    }

    public static List<int[]> findConflictingIntervals(int[][] appointments){
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b)-> a.value - b.value);
        List<int[]> result = new ArrayList<>();

        minHeap.add(new Pair(appointments[0][0], appointments[0][1]));
        for(int[] appointment: appointments){
            if(minHeap.isEmpty()){
                minHeap.add(new Pair<>(appointment[0], appointment[1]));
            }else{

                int size = minHeap.size();
                for(int i =0; i< size; i++){
                    Pair<Integer, Integer> top = minHeap.remove();
                    if(appointment[0] < top.value &&  appointment[0] > top.key){
                        result.add(new int[]{appointment[0], appointment[1]});
                        break;
                    }else{
                        minHeap.add(top);
                        minHeap.add(new Pair<>(appointment[0], appointment[1]));
                    }

                }

            }

        }
        return result;
    }
}
