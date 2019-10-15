/**
 * @author cvictory ON 2019-05-26
 */
public class CooldownStock {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] sleep = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sleep[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            sleep[i] = sell[i - 1];
            System.out.println(i + ": " + buy[i] + "," + sell[i] + "," + sleep[i]);
        }
        return Math.max(sell[prices.length - 1], sleep[prices.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new CooldownStock().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new CooldownStock().maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit2(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], i >= 2 ? sell[i - 2] - prices[i] : -prices[i]);
        }

        return sell[prices.length - 1];

    }
}
