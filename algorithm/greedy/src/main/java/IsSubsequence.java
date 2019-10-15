/**
 * @author cvictory ON 2019-07-20
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int j = 0;
        for (int i = 0; i < sa.length; i++) {
            for (; j < ta.length; j++) {
                if (ta[j] == sa[i]) {
                    break;
                }
                if (j == ta.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }
}
