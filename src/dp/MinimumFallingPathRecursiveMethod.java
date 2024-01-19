/*
 * This is a leetcode problem
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 * using dp technique is better, because for large inputs, we get time exceeding limit error
 * using recursive approach, using dp technique, we use the previous step calculation in
 * the next step, so it saves time.
  */
package dp;

public class MinimumFallingPathRecursiveMethod {
    public static void main(String[] args) {
       int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
      // int[][] matrix = {{-19, 57}, {-40, -5}};
      //  int[][] matrix = {{-80,-13,22},{83,94,-5},{73,-48,61}};
        int result = minFallingPathSum((matrix));
        System.out.println(result);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int cols = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            int result = findFallingPathSum(matrix, 0, i);
            min = Math.min(min, result);
        }
        return min;
    }

    public static int findFallingPathSum(int[][] matrix, int row, int col) {
        if (row == matrix.length - 1) return matrix[row][col];

        int currentCell = matrix[row][col];
        int left = (col == 0) ? Integer.MAX_VALUE : currentCell + findFallingPathSum(matrix, row + 1, col - 1);
        int down = currentCell + findFallingPathSum(matrix, row + 1, col);
        int right = (col == matrix[0].length - 1) ? Integer.MAX_VALUE : currentCell + findFallingPathSum(matrix, row + 1, col + 1);
        return findMin(left, down, right);
    }

    private static int findMin(int a, int b, int c) {
        return a < b && a<c ?  a : b<c ? b :c;
    }
}

