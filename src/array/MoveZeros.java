package array;

/*
* this is a leetcode problem
* https://leetcode.com/problems/move-zeroes/description/
*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Note that you must do this in-place without making a copy of the array.
* Example 1:
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]
*/

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
       // int[] arr = {0};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeros(int[] nums) {
        int n = nums.length;
            for (int i = 0, j = 0; j<n;) {
                if(nums[j] != 0){
                    swap(nums, i, j);
                    i++;
                }
                j++;
            }
    }

    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
