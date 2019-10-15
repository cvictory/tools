package math;

/**
 * @author cvictory ON 2019-07-27
 */
public class AgulyNumber {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            System.out.println("***" + i2 + ", " + i3 + ", " + i5 + " ====== "+ next2 + ", " + next3 + ", " + next5);
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
            System.out.println("---" + i2 + ", " + i3 + ", " + i5 + " : " + dp[i]);
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new AgulyNumber().GetUglyNumber_Solution(10));
//        System.out.println(new AgulyNumber().GetUglyNumber_Solution(11));
        System.out.println(new AgulyNumber().GetUglyNumber_Solution(22));
    }
}
