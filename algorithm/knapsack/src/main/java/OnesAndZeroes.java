import java.util.Arrays;

/**
 * @author cvictory ON 2019-05-26
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] nums = findOneAndZero(str);
            for (int i = m; i >= nums[0]; i--) {
                for (int j = n; j >= nums[1]; j--) {
//                    System.out.println(i + ", " + j + " : " + dp[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] findOneAndZero(String strs) {
        int[] num = new int[2];
        for (char str : strs.toCharArray()) {
            if (str == '0') {
                num[0] += 1;
            } else if (str == '1') {
                num[1] += 1;
            }
        }
//        System.out.println(num[0] + " , " + num[1]);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(new OnesAndZeroes().findMaxForm2(new String[]{"10", "0001", "111001", "1", "0"}, 3, 5));
        System.out.println(new OnesAndZeroes().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(new OnesAndZeroes().findMaxForm2(new String[]{"10", "0", "1"}, 1, 1));
    }


    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                }
                if (c == '1') {
                    ones++;
                }
            }

            for (int i = m; i >= ones; i--) {
                for (int j = n; j >= zeros; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - ones][j - zeros] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
