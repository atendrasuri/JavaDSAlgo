package com.suri.catest;

/*
-2, -3, 4, -1, -2, 1, 5, -3

expected:- maxSum = 7

result = arr[0];

currmaxSum = arr[0];

result = -2
currmaxSum = -2;


i =1
currmaxSum = math.max(currmaxSum+arr[i], arr[i]);
result = max(result, currmaxSum);

currmaxSum = max(-5, -3) = -3
result = (-2, -3) = -2

i=2
currmaxSum = (1, 4) = 4
result = (-2, 4) =4

i=3
currmaxSum = (3, -1) = 3
result = (4, 3) =4

i =4

currmaxSum = (1, 3) =3
result = (4, 3) =4

i=5

currmaxSum = (4, 1) =4
result = (4, 4) = 4

currmaxSum =




result[0] = arr[0];

for(int i=1;i<n;i++){
result[i] = math.max(result[i-1]+arr[i], arr[i]);

}




10, 20, 7




a=4

Example :- 10/2 =5
[5, 20, 7]
[3, 20,7]
[2,20, 7]
[1, 20, 7]

int op;

 while(op>0){




 }



/2






















 */





/*

ROW, COL;

for(no=1;no<6;no++)
 for(int i=0;i<row; i++){

   for(int j=0;j<col;j++){
      if(arr[i][j]==no){
        doDfs(arr, i, j, no, result);

      }

   }


 }

 public void doDfs(arr, i, j, no, result){

   if(i<0 || j<0 || i>=ROW || j>=COL || arr[i][j]!=no){
      return;
   }
   result.add<i, j>;
   arr[i][j]=0;

   doDfs(arr, i+1, j, no, result);
   doDfs(arr, i, j+1, no, result);
   doDfs(arr, i-1, j, no, result);
   doDfs(arr, i, j-1, no, result);



 }


 */


public class TestMarch01 {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
