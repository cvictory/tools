/**
 * @author cvictory ON 2019-05-26
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5}));
    }
}
