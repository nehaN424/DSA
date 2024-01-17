/**
 * This is a leetcode problem
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * The approach is that we iterate each cell in the grid,
 * if the value is zero, we ignore it, because it does not contribute in creating the island
 * if the value is one, then we make area as 1,  then we check its neighbours, top, left, right, bottom,
 * wherever we find it's any of the neighbours as 1, we add that in the area, and we recursively
 * do the same for its neighbours, after adding any cell in the area, we make that cell value
 * 0, so we do not keep adding that infinitely when we check its neighbours.
 *
 * if we don't want to make changes in the actual grid, we create a visited array of the same rows
 * and cols as the actual grid, and whatever cell we visit, we mark it as 1, and while calculating
 * the area we check also that if the cell is already visited, we return 0.
 * here, findAreaOfIsland_method2 use this approach, means it includes visited area
 * and
 * findAreaOfIsland use first approach, it makes changes in the actual grid
 */
package array;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int maxArea = Integer.MIN_VALUE;

        int[][] grid =
                {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                };

        int rows = grid.length;
        int cols = grid[0].length;
       // int[][] visited = new int[rows][cols]; //required in case of method2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               maxArea = Math.max(maxArea, findAreaOfIsland(grid, i, j));
               //  maxArea = Math.max(maxArea, findAreaOfIsland_method2(grid, visited, i, j));
            }
        }
        System.out.println(maxArea);
    }

    public static int findAreaOfIsland(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[row][col] == 0) return 0;
        int area = 1;

        grid[row][col] = 0;
        if (row - 1 >= 0) {
            area += findAreaOfIsland(grid, row - 1, col);
        }
        if (row + 1 < rows) {
            area += findAreaOfIsland(grid, row + 1, col);
        }
        if (col - 1 >= 0) {
            area += findAreaOfIsland(grid, row, col - 1);
        }
        if (col + 1 < cols) {
            area += findAreaOfIsland(grid, row, col + 1);
        }

        return area;
    }

    public static int findAreaOfIsland_method2(int[][] grid, int[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[row][col] == 0 || visited[row][col] == 1) return 0;

        int area = 1;
        visited[row][col] = 1;

        if (row - 1 >= 0) {
            area += findAreaOfIsland_method2(grid, visited, row - 1, col);
        }
        if (row + 1 < rows) {
            area += findAreaOfIsland_method2(grid, visited, row + 1, col);
        }
        if (col - 1 >= 0) {
            area += findAreaOfIsland_method2(grid, visited, row, col - 1);
        }
        if (col + 1 < cols) {
            area += findAreaOfIsland_method2(grid, visited, row, col + 1);
        }

        return area;
    }
}
