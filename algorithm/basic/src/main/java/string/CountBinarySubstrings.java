package string;

/**
 * @author cvictory ON 2019-06-03
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int cl = 1, pl = 0;
        int r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cl++;
            } else {
                pl = cl;
                cl = 1;
            }
            if (cl <= pl) {
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("10101"));
    }
}
