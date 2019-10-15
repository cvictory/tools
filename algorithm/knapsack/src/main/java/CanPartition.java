/**
 * @author cvictory ON 2019-07-22
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int count = countTotal(nums);
        if (count % 2 != 0) {
            return false;
        }
        int target = count / 2;
        boolean[] dp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            for (int j = target; j >= c; j--) {
                dp[j] = dp[j] | dp[target - c];
            }
        }
        return false;
    }

    private int countTotal(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}
