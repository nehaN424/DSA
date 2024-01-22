/* Leetcode problem - Two Sum II - Input Array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description
 *
 * The solition provided has time complexity O(n) and no extra space used, so
 * space complexity is O(1).
 *
* */
package array;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
//        int[] numbers = {2, 7, 11, 15};
//        int target = 9;

//        int[] numbers = {2,3,4};
//        int target = 6;

        int[] numbers = {-1,0};
        int target = -1;

        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
