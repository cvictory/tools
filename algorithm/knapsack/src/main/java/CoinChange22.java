/**
 * @author cvictory ON 2019-08-04
 */
public class CoinChange22 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i<= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
