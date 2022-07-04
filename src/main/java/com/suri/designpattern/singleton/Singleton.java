package com.suri.designpattern.singleton;

import java.io.Serializable;

/*

MUST READ

What are the different ways we can break a singleton pattern in Java

It can break if the class is Serializable
It can break if its 'Clonable`
You can break by Reflection (I believe)
it can break ff multiple classloaders are loaded the class


How do you solve rule breakers?

It is much safer to do eager initialization
To prevent deserializing to create new object you may override readResolve() method in your class and throw exception
To prevent cloning, you may overrride clone() and throw CloneNotSupported exception
To escape for reflective instantion, we can add check in the constructor and throw exception.


After all I would suggest to use Enum as the safest way for Singleton (Since java5 the best way to do it is to use an enum)
 */
class Singleton implements Serializable, Cloneable {

    private static Singleton singletonIntance;

    private Singleton(){

    }

    public static Singleton  getInstance(){

        if(singletonIntance==null)
        {
            synchronized (Singleton.class){
                if(singletonIntance==null){
                    singletonIntance = new  Singleton();
                }
            }
        }

        return singletonIntance;

    }

    public Object readResolve(){
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}