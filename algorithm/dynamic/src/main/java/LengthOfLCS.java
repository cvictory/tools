/**
 * @author cvictory ON 2019-05-25
 */
public class LengthOfLCS {

    public int lengthOfLCS(char[] nums1, char[] nums2) {

        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    public static void main(String[] args) {
        char[] nums1 = {'B', 'D', 'C', 'A', 'B', 'A'};
        char[] nums2 = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};

        System.out.println(new LengthOfLCS().lengthOfLCS(nums1, nums2));
    }
}
