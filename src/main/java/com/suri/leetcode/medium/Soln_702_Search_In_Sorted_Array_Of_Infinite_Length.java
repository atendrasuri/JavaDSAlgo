package com.suri.leetcode.medium;

/*

Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.
Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.



https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
https://www.callicoder.com/search-in-sorted-infinite-array/
https://www.youtube.com/watch?v=awMDD7sGWVU&ab_channel=AnujBhaiya
 */
public class Soln_702_Search_In_Sorted_Array_Of_Infinite_Length {

    public static void main(String[] args) {

    }

    public static int searchInfinite(int arr[], int key){
        int low = 0;
        int high =1;
        while(arr[high]<key){
            low = high;
            high = 2*high;
        }
        return binarySearch(arr, key, low, high);
    }

    public static int binarySearch(int arr[], int key, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
