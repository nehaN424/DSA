/* Leetcode Set Mismatch problem
* https://leetcode.com/problems/set-mismatch/description/
* The solution given here has time complexity O(n), and no extra space used.
* */
package array;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        // int[] arr = {1, 1};
        // int[] arr = {1,3,3};
        //int[] arr = {2, 2};
        int[] result = findErrorNums(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findErrorNums(int[] nums)  {
        int[] result = new int[2];
        //sorting the array using cyclic sort
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int correctPos = nums[i] - 1;
                if(nums[correctPos] == nums[i]){
                    break;
                }
                swap(nums, i, correctPos);
            }
        }
        //finding dupplicate and missing number
         for(int i = 0; i<nums.length;i++){
             if(nums[i] != i+1){
                 result[0] = nums[i];
                 result[1] = i+1;
                 break;
             }
         }
        return result;
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
