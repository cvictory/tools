/**
 * @author cvictory ON 2019-05-27
 */
public class KeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= n / 2; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new KeysKeyboard().minSteps(3));
    }
}
