import java.util.Map;

/**
 * @author cvictory ON 2019-08-04
 */
public class StockWithFee {
    public int maxProfit(int[] prices, int fee) {

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new StockWithFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
