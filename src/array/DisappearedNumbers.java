/* This is a leetcode problem
 * Find All numbers disappeared in an array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 *  return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Since the numbers are in the range [1,n]. So we will use cyclic sort first to place all
 * the elements at their correct position, ignoring the duplicates, wherever we see a
 * duplicate number, we ignore it and move further.
 *
 * Then we will traverse this array again, and compare the value at each position
 * if nums[i] != i+1, then it is duplicate, and at this position the element is missing, so we
 * got a missing number i.e. i+1. Keep doing the same for the whole array to find all
 * missing numbers..
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static void main(String[] args) {
       // int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] input = {1, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(input);
        disappearedNumbers.forEach(System.out::println);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        var disappearedNumbers = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;
                if (nums[correctIndex] == nums[i]) {
                    break;
                }
                swap(nums, correctIndex, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                disappearedNumbers.add(i + 1);
            }
        }
        return disappearedNumbers;
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
