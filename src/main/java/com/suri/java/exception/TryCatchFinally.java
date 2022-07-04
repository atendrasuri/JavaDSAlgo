package com.suri.java.exception;

public class TryCatchFinally {


    public static void main(String[] args) throws Exception {
        System.out.println(m1());

    }
    public static int m1()throws Exception{

        int r=0;
        try{

            r = 10/0;
        }catch (Exception e){
            throw e;
        }finally {
            return 10;
        }
    }
}


class Base{

     void m1() throws Exception{}
}

class Child extends Base{
    void m1()throws Exception{

    }
}




