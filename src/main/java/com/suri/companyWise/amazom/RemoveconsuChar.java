package com.suri.companyWise.amazom;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class RemoveconsuChar {
    public static void main(String[] args) {

        String str = "helllllololol";

        removeadjacent(str);


    }


    public static void removeadjacent(String str) {
        int n = str.length();
        if (n <= 1) {
            System.out.println(str);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                if (i < n - 2 && str.charAt(i) != str.charAt(i + 2)) {
                    i += 2;
                } else {
                    i++;
                }
            }
            if (i != n - 1) {
                sb.append(str.charAt(i));
            } else {
                if (i == n - 1 && str.charAt(i) != str.charAt(i - 1)) {
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
    }


}