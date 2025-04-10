package com.suri.interview;

import java.util.ArrayList;
import java.util.List;

//Problem: https://www.hackerrank.com/challenges/chocolate-feast
/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/04/19
 * @Description: (Overwrite)
 * Little Bobby loves chocolate. He frequently goes to his favorite  store, Penny Auntie, to buy them.
 * They are having a promotion at Penny Auntie.
 * If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 *
 * For example, Bobby has n=15 to spend on bars of chocolate that cost c=3 each.
 * He can turn in  wrappers to receive another bar.
 * Initially, he buys  bars and has  wrappers after eating them. He turns in  of them, leaving him with , for more bars.
 * After eating those two, he has  wrappers, turns in  leaving him with  wrapper and his new bar.
 * Once he eats that one, he has  wrappers and turns them in for another bar. After eating that one, he only has  wrapper, and his feast ends.
 * Overall, he has eaten  bars.
 * @History:
 */
public class ChocolateFeast {

    public static void main(String[] args) {

        List<String> list= new ArrayList<>();
        list.add("10");list.add(" ");
        list.add("2");list.add(" ");
        list.add("5");
        chocolate(list);


    }

    public static void chocolate(List<String> d){


            int n = Integer.parseInt(d.get(0));

            int c = Integer.parseInt(d.get(2));
            int m = Integer.parseInt(d.get(4));

            int ate = 0;

            int chocolates = n / c;

            ate += chocolates;

            while(chocolates >= m)
            {
                ate += chocolates / m;
                chocolates = (chocolates / m) + (chocolates % m);
            }
            System.out.println(ate);


    }
}