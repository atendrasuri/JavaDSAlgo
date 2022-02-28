package com.suri.catest;


import java.util.stream.Stream;

/*

1 1           1  1  1        3  3  3
2 2    *      2  2  2  =  6  6  6
3 3                              9  9  9



    1*1+1*2   2*1+

 */
public class Test {
    public static void main(String[] args) throws Exception {


        int mat1[][] = {{1,1},{2,2},{3,3}};

        int mat2[][] = {{1,1,1},{2,2,2}};


        int mat3[][] = multiplyMatrix(mat1, mat2);


        for(int i=0;i<mat3.length;i++){
            for(int j=0;j<mat3[0].length;j++){
                System.out.print(mat3[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static int [][] multiplyMatrix(int mat1[][], int mat2[][])throws Exception{

        if(mat1.length != mat2[0].length){
            throw new Exception("Multiplication not possible");
        }

        /*
        1 1           1  1  1        3  3  3
        2 2    *      2  2  2  =  6  6  6
        3 3                              9  9  9
         */

        int mat3[][] = new int[mat1.length][mat2[0].length];

        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat2[0].length;j++){
                for(int k=0;k<mat1[0].length;k++){
                 mat3[i][j]=     mat3[i][j]+(mat1[i][k]*mat2[k][j]);
                }
            }
        }

        return mat3;

    }





}
