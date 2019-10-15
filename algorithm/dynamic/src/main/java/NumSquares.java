import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cvictory ON 2019-05-23
 */
public class NumSquares {

    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int dp[] = new int[n + 1];
        List<Integer> vlist = generateList(n);
        for (int i = 1; i <= n; i++) {
            int num = Integer.MAX_VALUE;
            for (Integer t : vlist) {
                if (i < t) {
                    break;
                }
                num = Math.min(dp[i - t] + 1, num);
            }
            dp[i] = num;
        }
//        for(int c : dp){
//            System.out.println("-" + c);
//        }
        return dp[n];
    }

    private List<Integer> generateList(int n) {
        List<Integer> list = new ArrayList<>();
        int diff = 1;
        int value = 0;
        for (int i = 1; i < n; i++) {
            value += diff;
            list.add(value);
            diff += 2;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(13));
        System.out.println(new NumSquares().numSquares(12));
    }

}
