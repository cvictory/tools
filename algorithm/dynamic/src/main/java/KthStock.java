import java.util.Map;

/**
 * @author cvictory ON 2019-07-23
 */
public class KthStock {

    public int maxProfit(int k, int[] prices) {

        int[][] maxProfit = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int buyMax = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                maxProfit[i][j] = Math.max(maxProfit[i][j - 1], buyMax + prices[j]);
                buyMax = Math.max(buyMax, maxProfit[i - 1][j] - prices[j]);
            }
        }
        return maxProfit[k][prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new KthStock().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
