package com.suri.catest;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Test11111 {
    public static void main(String[] args) {

        AddNumber<Number> addNumber = new AddNumber<>();
        addNumber.add(new Integer(1));
        addNumber.add(new Double(2.0));

        Integer arr [] = {10,3,10,2, 20};
        List<Integer> list = Arrays.asList(arr);
        OptionalDouble average = list.stream().mapToInt(n -> n * n).filter(n -> n >= 10).average();
        if(average.isPresent()){
            System.out.println(average);
        }

        String strarr[] = {"one", "two"};
        System.out.println(Arrays.toString(strarr));

        List<Integer> integers = Arrays.asList(1, 2, 3, 0, 5, 6);

        for(Integer i : integers){

            try{
                int result = 20/i;
                System.out.println("result "+result);
            }catch (Exception ex){
                throw ex;
            }
        }

    }
}

class AddNumber<T>{

    void add(T t){
        System.out.println(" "+t);
    }
}
