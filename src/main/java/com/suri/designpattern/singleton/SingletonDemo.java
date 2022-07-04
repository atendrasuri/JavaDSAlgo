package com.suri.designpattern.singleton;


import com.suri.catest.test28.MySingleton;

import java.io.*;

public class SingletonDemo {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        Singleton mySingleton1  = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        //Object obj3 = obj1.clone();

        System.out.println(""+mySingleton1 +"---->"+obj2);
        //System.out.println(obj3);


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


