class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        // Out of bounds or water
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        // Count current cell
        int area = 1;

        // Visit 4 directions
        area += dfs(grid, row + 1, col); // down
        area += dfs(grid, row - 1, col); // up
        area += dfs(grid, row, col + 1); // right
        area += dfs(grid, row, col - 1); // left

        return area;
    }
}
