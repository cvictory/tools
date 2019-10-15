import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cvictory ON 2019-05-26
 */
public class CoinChange {

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        doAddQueue(coins, q, amount);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ++sum;
            while (--size >= 0) {
                Integer v = q.poll();
                if (v == 0) {
                    return sum;
                }
                if (v < 0) {
                    continue;
                }
                doAddQueue(coins, q, v);
            }
        }
        return -1;
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private void doAddQueue(int[] coins, Queue<Integer> q, int v) {
        for (int coin : coins) {
            if (v >= coin) {
                q.offer(v - coin);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));

        System.out.println(new CoinChange().coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange2(new int[]{2}, 3));


        System.out.println(new CoinChange().coinChange3(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange3(new int[]{2}, 3));
    }

}
