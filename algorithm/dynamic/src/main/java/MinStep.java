/**
 * @author cvictory ON 2019-07-23
 */
public class MinStep {
    public int minSteps(int n) {
        if (n == 1) return 0;
        System.out.println(Math.sqrt(n));
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return i + minSteps(n / i);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new MinStep().minSteps(37));
    }
}
