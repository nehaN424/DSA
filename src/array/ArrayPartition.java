package array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * Example :
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */

public class ArrayPartition {

    public  static  void main(String[] args){
        int[] input = {1, 4, 3, 2};
        int result = maxSumOfPairs(input);
        System.out.println(result);
    }

    public static int maxSumOfPairs(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i< n-1; i+=2){
         sum += arr[i];
        }
        return  sum;
    }
}
