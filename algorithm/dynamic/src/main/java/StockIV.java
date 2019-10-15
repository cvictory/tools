/**
 * @author cvictory ON 2019-05-27
 */
public class StockIV {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int max = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
                max = Math.max(max, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new StockIV().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new StockIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

}
