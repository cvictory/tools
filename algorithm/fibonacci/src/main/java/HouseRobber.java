/**
 * @author cvictory ON 2019-05-22
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else if (i == 1) {
                sum[1] = Math.max(nums[0], nums[1]);
            } else {
                sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
            }
        }
        return sum[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1, 3}));
    }
}
