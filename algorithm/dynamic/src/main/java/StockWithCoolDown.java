/**
 * @author cvictory ON 2019-08-04
 */
public class StockWithCoolDown {

    public int maxProfit(int[] prices) {

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = prices[0] > prices[1] ? 0 : prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new StockWithCoolDown().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
