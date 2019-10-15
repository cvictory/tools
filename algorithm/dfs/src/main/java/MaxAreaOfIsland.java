import java.util.Stack;

/**
 * @author cvictory ON 2019-05-19
 */
public class MaxAreaOfIsland {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIslandTest(int[][] grid) {

        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                max = Math.max(dfs2(grid, i, j), max);
            }
        }
        return max;
    }

    public int dfs2(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int max = 1;
        for (int[] d : direction) {
            int r = d[0] + i, c = d[1] + j;
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                continue;
            }
            if (grid[r][c] == 0) {
                continue;
            }
            max += dfs2(grid, r, c);
        }
        return max;
    }


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
//        System.out.println(r + "," + c);
        if (r < 0 || c < 0 || r >= grid.length - 1 || c >= grid[0].length - 1 || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int dfs = 1;
        for (int[] direct : direction) {
            dfs += dfs(grid, r + direct[0], c + direct[1]);
        }
        return dfs;
    }

    public static void main(String[] args) {
        int[][] param = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] param2 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(param));
        System.out.println(new MaxAreaOfIsland().maxAreaOfIslandTest(param2));
    }
}
