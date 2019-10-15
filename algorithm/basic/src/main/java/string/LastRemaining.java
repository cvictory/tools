package string;

/**
 * @author cvictory ON 2019-07-28
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(5, 2));
        System.out.println(new LastRemaining().LastRemaining_Solution(5, 3));
    }
}
