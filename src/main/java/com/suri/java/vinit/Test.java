package com.suri.java.vinit;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Byte.MIN_VALUE;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Test extends Exam {

    private String level ="hard";

    public static void main(String[] args) {

        ArrayList<Integer> a =new ArrayList<>();
        a.add(2);
        a.add(-1);
        a.add(0);
        a.add(3);
        int i=0;
        while(i<a.size())
            if (a.get(i) < 0)
                System.out.println( a.remove(i));
            else
                i++;

        /*Integer a = null;
        int b =a;
        System.out.println(b);*/

        try {
            int c = 1/0;
        } catch (Exception e) {
            //System.out.println("E");
            throw e;
        } finally {
            System.out.println("F");
        }


        Test test = new Test();

        test.printLevel();

    }
}

class Exam{


    private String level ="Easy";

    public void printLevel(){
        System.out.println(level);
    }
}