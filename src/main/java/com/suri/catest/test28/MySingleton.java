package com.suri.catest.test28;

import java.io.Serializable;

public class MySingleton  implements Serializable, Cloneable {


    private static MySingleton mySingleton = null;
    private MySingleton(){

    }

    public static MySingleton getInstance(){

        if(mySingleton==null){
            synchronized (MySingleton.class){
                if (mySingleton==null){
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }

    public Object readResolve(){
        return getInstance();
    }
   /* public Object clone(){

    }*/
}
