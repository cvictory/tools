/**
 * @author cvictory ON 2019-07-22
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] = dp[j] + grid[i][j];
            }
        }
        return dp[grid.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
