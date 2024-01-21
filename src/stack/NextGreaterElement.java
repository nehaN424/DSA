/*
* Given an array of integers, find out the next greater element for each element in the array
* Example : arr = {1, 3, 4, 2}
* output = {3, 4, -1, -1}
* For 1, next greater element is 3, for 3, it is 4
* for 4, there is no greater element after element 4, so it will be -1.
* for 2, as it is last element, no further greater element, so it will also be 4.
*
* Used monotonic stack in this, Time Complexity : O(n),
* Space complexity : O(n) for maintaining stack.
*
*/

package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[] nextGreaterElement = nextGreaterElements(arr);
        System.out.println(Arrays.toString(nextGreaterElement));
    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nextGreaterElements = new int[n];
        Arrays.fill(nextGreaterElements, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                nextGreaterElements[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return nextGreaterElements;
    }
}
