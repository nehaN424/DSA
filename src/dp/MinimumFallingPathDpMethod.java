/*
* This is a leetcode problem
* https://leetcode.com/problems/minimum-falling-path-sum/description/
* using dp technique is better, because for large inputs, we get time exceeding limit error
* using recursive approach, using dp technique, we use the previous step calculation in
* the next step, so it saves time.
 */

package dp;

import java.util.Arrays;

public class MinimumFallingPathDpMethod {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        // int[][] matrix = {{-19, 57}, {-40, -5}};
        //int[][] matrix = {{-80, -13, 22}, {83, 94, -5}, {73, -48, 61}};
        int result = minFallingPathSum((matrix));
        System.out.println(result);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        Integer[][] dp = new Integer[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                findFallingPathSum(matrix, i, j, dp);
            }
        }
        Arrays.sort(dp[0]);
        return dp[0][0];
    }

    public static void findFallingPathSum(int[][] matrix, int row, int col, Integer[][] dp) {
        if (row == matrix.length - 1) {
            dp[row][col] = matrix[row][col];
            return;
        }
        int currentCell = matrix[row][col];
        int left = (col == 0) ? Integer.MAX_VALUE : currentCell + dp[row + 1][col - 1];
        int down = currentCell + dp[row + 1][col];
        int right = (col == matrix[0].length - 1) ? Integer.MAX_VALUE : currentCell + dp[row + 1][col + 1];
        dp[row][col] = findMin(left, down, right);
    }

    private static int findMin(int a, int b, int c) {
        return a < b && a < c ? a : b < c ? b : c;
    }
}
