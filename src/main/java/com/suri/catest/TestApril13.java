package com.suri.catest;

import java.util.Arrays;
import java.util.UUID;


public class TestApril13 {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        //String uuidAsString = uuid.toString().substring(0, 11);
        System.out.println(uuidAsString);

        String [] arr = {"A", "B", "C"};
        System.out.println(Arrays.toString(arr));
    }
}
