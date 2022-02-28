package com.suri.datastructure.arrays.singledimension.sortedAndRotated;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SortedandRotated {
    public static void main(String[] args) {

        int array[] = {156, 235, 457, 21, 32, 43, 74, 75, 86, 97, 108, 149};
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int arr2[] = {30, 40, 50, 10, 20};

        int arr3[] = {1,3};
        int k =3;


//        System.out.println(findElement(array,32));
//        System.out.println(findElement(arr,9));
//        System.out.println(findElement(arr1,3));
        System.out.println(findElement(arr2,10));

    }

    public static int findElement(int arr[], int key){

        int pivot= pivot(arr);

        if(arr[pivot]==key){
            return pivot;
        }
        if(arr[0]<=key ){
            return binarySearch(arr,0, pivot-1,key);
        }
        else{
            return binarySearch(arr, pivot+1, arr.length-1, key);
        }

    }


    public static int binarySearch(int arr[], int l, int r, int key){

        while(l<=r){

            int mid= (l+r)/2;

            if(arr[mid]==key){
                return mid;
            }
            if(key<arr[mid]){
                r= mid-1;
            }
            else{
                l= mid+1;
            }
        }
        return -1;
    }

    public static int pivot(int arr[]) {

        if (arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[l] <= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }
}