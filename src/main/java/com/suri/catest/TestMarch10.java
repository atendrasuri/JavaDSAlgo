package com.suri.catest;

import java.util.ArrayList;
import java.util.List;

public class TestMarch10 {
    public static void main(String[] args) {

        // string s1 = "My name is Atendra Kumar is Kumar";
        // String key = "is Kumar";

        /*
          my -0
          name -1
          is 2
        Atendra 3
        Kumar 4
         */

        String str = "My name is Atendra Kumar is Kumar";
        String keys = "is Kumar";

        System.out.println(findAllInterMediateStringWithSmallestSubString1(str, keys));
    }

    public static List<String> findAllInterMediateStringWithSmallestSubString1(String str1, String keys){
        List<String> result = new ArrayList<>();

        String strArr[] = str1.split(" ");
        String firstKey = keys.split(" ")[0];
        String secondKey = keys.split(" ")[1];

        int begin =-1;
        int end =-1;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i< strArr.length;i++){
            if(strArr[i].equals(firstKey)){
                begin=i;
            }
            if(strArr[i].equals(secondKey)){
                end=i;
            }
            if(begin!=-1 && end!=-1){
                minDistance = Math.min(minDistance, Math.abs(end-begin));
            }
        }
        if(minDistance!=Integer.MAX_VALUE){
            for(int i = begin+1;i<minDistance;i++){
                result.add(strArr[i]);
            }
        }


        return result;
    }


    static class Pair{
        String key;
        Integer index;
        Pair(){

        }

    }
    public static List<String> findAllInterMediateStringWithSmallestSubString(String str1, String keys){
        List<String> result = new ArrayList<>();
        String strArr[] = str1.split(" ");
        String firstKey = keys.split(" ")[0];
        String secondKey = keys.split(" ")[1];

        List<Pair>  firstKeyOccur = new ArrayList<>();

        List<Pair>  secondKeyOccur = new ArrayList<>();


        /*for(int i=0;i< strArr.length;i++){
            if(strArr[i].equals(firstKey)){
                Pair mypair = new Pair();
                mypair.key = firstKey;
                mypair.index =i;
                firstKeyOccur.add(mypair);
            }
            if(strArr[i].equals(secondKey)){
                Pair mypair = new Pair();
                mypair.key = firstKey;
                mypair.index =i;
                secondKeyOccur.add(mypair);
            }
        }
        int idex  = Integer.MAX_VALUE;
        int begin =0;
        int end =0;
        for(int i =0; i<firstKeyOccur.size() && i<secondKeyOccur.size();i++){
            int distance = secondKeyOccur.get(i).index- firstKeyOccur.get(i).index;
            if(distance<idex){
                begin =firstKeyOccur.get(i).index;
                end = secondKeyOccur.get(i).index;
                idex = distance;
            }
        }*/

        //result.add(str1.substring(begin, end));










        return result;

    }

}



