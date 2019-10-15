/**
 * @author cvictory ON 2019-07-20
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0], preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = (preMax < 0) ? nums[i] : preMax + nums[i];
            max = Math.max(preMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
