package com.suri.catest.test28;

import java.io.*;

public class TestMain {
    public static void main(String[] args) throws IOException {

       MySingleton mySingleton1 = MySingleton.getInstance();

        MySingleton mySingleton2 = MySingleton.getInstance();

        System.out.println(mySingleton1 +"   "+ mySingleton2);
        ObjectOutputStream objectOutputStream =null;
        try {
            objectOutputStream= new ObjectOutputStream(new FileOutputStream("abc"));

            objectOutputStream.writeObject(mySingleton1);
        }catch (Exception ex){

        }finally {
            objectOutputStream.close();
        }

        ObjectInputStream objectInputStream =null;
        MySingleton mySingleton3=null;
        try {
            objectInputStream= new ObjectInputStream(new FileInputStream("abc"));

            mySingleton3 = (MySingleton)objectInputStream.readObject();
        }catch (Exception ex){

        }finally {
            objectInputStream.close();
        }

        System.out.println(mySingleton1+"    "+mySingleton3);



    }
}
