/**
 * @author cvictory ON 2019-07-22
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int[] p = new int[nums.length];
        p[0] = nums[0];
        p[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            p[i] = Math.max(p[i - 1], p[i - 2] + nums[i]);
        }
        return p[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
