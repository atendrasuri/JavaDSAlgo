package com.suri.companyWise.google;

/*

Public class Node {
	NodeType t; // INNER, LEAF
	Node left;
	Node right;
	Char value;

	Public static String encode(String input, Node root){
              }

	Public static String decode(String encoded, Node root){
}


Public class Node {
	NodeType t; // INNER, LEAF
	Node left;
	Node right;
	Char value;

	Public static String encode(String input, Node root){
              }

	Public static String decode(String encoded, Node root){
}


A: 0
B: 10
C: 11
AABC : 001011


 */
public class Test11 {
    public static void main(String[] args) {

    }

//AABC : 001011
    public static String encode(String input, Node root){

        StringBuilder result = new StringBuilder();
        for(int i=0;i<input.length();i++){
            encodeUtil(input.charAt(i), root, result, ' ');
        }
        return result.toString();

    }

    private static boolean encodeUtil(char ch, Node root, StringBuilder result, char appendchar ){

        if(root==null){
            return false;
        }
        if(root.t.equals(NodeType.LEAF )){
            if(root.value==ch){
                result.append(appendchar);
                return true;
            }else{
               return false;
            }
        }

        boolean left = encodeUtil(ch, root.left, result, '0');

        if(!left) {
            return encodeUtil(ch, root.right, result, '1');
        }
       return left;
    }


    public static String decode(String encoded, Node root){


        String result = null;


        return result;

    }


}



 class Node {
     NodeType t; // INNER, LEAF
     Node left;
     Node right;
     char value;
 }
enum NodeType{
    INNER, LEAF;

}




