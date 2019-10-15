/**
 * @author cvictory ON 2019-05-26
 */
public class TargetSum {
    public int findTargetSumWays1(int[] nums, int S) {
        return doFindTargetSumWays(nums, S, 0);
    }

    private int doFindTargetSumWays(int[] nums, int S, int s) {
        System.out.println(S + " ; " + s);
        if (s == nums.length) {
            if (S == 0) {
                return 1;
            }
            return 0;
        }
        return doFindTargetSumWays(nums, S + nums[s], s + 1) + doFindTargetSumWays(nums, S - nums[s], s + 1);
    }

//    public int findTargetSumWays2(int[] nums, int S) {
//        int[] dp = new int[nums.length + findMax(nums)];
//        for (int num : nums) {
//            for (int j = S; j >= num; j++) {
//                dp[j] = dp[j - num] + dp[j + num];
//            }
//        }
//        return dp[S];
//    }

    private int findMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays1(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(new TargetSum().findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
