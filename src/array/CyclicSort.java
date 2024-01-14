/* Cyclic Sort
 * Cyclic sort algorithm is used when the input array has elements from range [1,n],
 * where n is the number of elements.
 * And the second condition is that the elements are unique in the array.
 */
package array;

public class CyclicSort {
    public static void main(String[] args) {
        int[] input = {2, 1, 5, 3, 4, 7, 6};
        cyclicSort(input);
        System.out.println("Array after sorting");
        for (int element : input) {
            System.out.println(element);
        }
    }

    public static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int correctPos = arr[i] - 1;
                swap(arr, i, correctPos);
            }
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
