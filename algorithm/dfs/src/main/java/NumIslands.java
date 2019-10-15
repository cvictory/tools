/**
 * @author cvictory ON 2019-05-19
 */
public class NumIslands {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxIsland += dfs(grid, i, j);
            }
        }
        return maxIsland;
    }

    private int dfs(char[][] grid, int r, int c) {
//        System.out.println(r + "," + c);
        if (r < 0 || c < 0 || r >= grid.length - 1 || c >= grid[0].length - 1 || grid[r][c] == '0') {
            return 0;
        }
        grid[r][c] = '0';
        for (int[] direct : direction) {
            dfs(grid, r + direct[0], c + direct[1]);
        }
        return 1;
    }

    public static void main(String[] args) {
        char[][] param = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(new NumIslands().numIslands(param));

        char[][] param2 = {{'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};

        System.out.println(new NumIslands().numIslands(param2));
    }
}
