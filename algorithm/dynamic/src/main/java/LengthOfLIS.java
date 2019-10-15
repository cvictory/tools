import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cvictory ON 2019-05-25
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    System.out.println(i + " ;" + j + " : " + dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
            println(tails);
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] param = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LengthOfLIS().lengthOfLIS(param));
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{4, 3, 6, 5, 7}));
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{4, 9, 10, 5,  6, 7}));
    }

    private void println(int[] list){
        for(int l : list){
            System.out.print(l);
            System.out.print(" , ");
        }
        System.out.println("");
    }
}
