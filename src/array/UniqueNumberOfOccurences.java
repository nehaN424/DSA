/*
* this is a leetcode problem
* https://leetcode.com/problems/unique-number-of-occurrences/
* Given an array of integers arr, return true
* if the number of occurrences of each value in the array is unique or false otherwise.
* Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
*/
package array;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueNumberOfOccurences {
    public static void main(String[] args) {
       // int[] arr = {1,2,2,1,1,3};
      //  int[] arr = {1,2};
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean result = uniqueNumberOfOccurences(arr);

        System.out.println(result);
    }
    public static boolean uniqueNumberOfOccurences(int[] arr){
        Arrays.sort(arr);
        HashSet<Integer> frequencySet = new HashSet<>();
        int n = arr.length;
        int count = 1;

        for(int i = 1; i < n; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }else{
                if(!frequencySet.add(count)) return false;
                count = 1;
            }
        }
        if(!frequencySet.add(count)) return false;
        return true;
    }
}
