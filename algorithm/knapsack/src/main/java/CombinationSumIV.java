import java.util.Arrays;

/**
 * @author cvictory ON 2019-05-26
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
