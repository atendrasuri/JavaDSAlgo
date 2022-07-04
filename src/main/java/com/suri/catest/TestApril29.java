package com.suri.catest;

public class TestApril29 {

    public static void main(String[] args) {

        //System.out.println(remove("ABCDEFFFG", 'F'));

        printPatter("PROGRAM");

    }

    public static String remove(String str, char ch){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<str.length(); i++){
            if(str.charAt(i)!=ch){
                stringBuilder.append(str.charAt(i)) ;
            }
        }
        return stringBuilder.toString();
    }

    public static void printPatter(String str){

        int k=1;
        for(int i=0;i<str.length();i++){

            for(int space = str.length()-1; space>=0;space= space-2){
                System.out.print(" ");
            }

            for(int j=1;j<=k;j++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
            k= k+2;
        }

    }


    /*

    CREATE TABLE EMPLOYEE(
     ID         NUMBER(10) NOT NULL,
     EMP_NAME    VARCHAR2(40),
    );

    ALTER TABLE ADD new col
    personal -1 work-2, home-3







     */

    //Exception part

    // Global Exception

    // define localaization either keep in property of some persitance

    //Controller

    //InventoryController{
    //
    // endpoint-? /paceOrde
    //
    // }


    // InventoryService{
    //
       // check product is in Inventory or not{}

      // manage inventory
    //
        //
    // }

    //Validation framework

    //Interface IOrder
    //Interface Payment


    //Order implements IOrder{
    //

    //
    //
    // }



}
