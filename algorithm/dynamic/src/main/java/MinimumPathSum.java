/**
 * @author cvictory ON 2019-05-23
 */
public class MinimumPathSum {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minPathSum(int[][] grid) {
        return doSum(grid, new boolean[grid.length][grid[0].length], 0, 0);
    }

    private int doSum(int[][] grid, boolean[][] haveVisisted, int r, int c) {
        System.out.println(r + " ; " + c);
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            System.out.println("t --- " + grid[r][c]);
            return grid[r][c];
        }

        int sum = Integer.MAX_VALUE;
        for (int[] direction : directions) {
            if (r + direction[0] >= grid.length || c + direction[1] >= grid[0].length || r + direction[0] < 0 || c + direction[1] < 0) {
                continue;
            }
            if (haveVisisted[r + direction[0]][c + direction[1]]) {
                continue;
            }
            haveVisisted[r + direction[0]][c + direction[1]] = true;
            int tmpSum = doSum(grid, haveVisisted, r + direction[0], c + direction[1]);
            haveVisisted[r + direction[0]][c + direction[1]] = false;
            if (tmpSum == Integer.MAX_VALUE) {
                continue;
            }
            sum = Math.min(tmpSum, sum);
        }
        if (sum == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return sum + grid[r][c];
    }

    public static void main(String[] args) {
        int[][] param = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinimumPathSum().minPathSum(param));
    }
}
