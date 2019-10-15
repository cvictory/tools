package string;

/**
 * @author cvictory ON 2019-08-05
 */
public class KmpSearch {

    private int[] kmpMatch(String target) {
        int len = 0;
        int[] r = new int[target.length()];

        for (int i = 1; i < target.length(); i++) {
            if (len > 0 && target.charAt(len) != target.charAt(i)) {
                len = 0;
            }
            if (target.charAt(len) == target.charAt(i)) {
                len++;
            }
            r[i] = len;
        }
        return r;
    }

    public boolean kmpSearch(String s, String pattern) {
        int[] kmp = kmpMatch(pattern);
        for(int i : kmp){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            while (pos > 0 && s.charAt(i) != pattern.charAt(pos)) {
                pos = kmp[pos - 1];
                System.out.println("--" + pos);
            }

            if (s.charAt(i) == pattern.charAt(pos)) {
                pos++;
            }
            System.out.println(i + ", " + pos);
            if (pos == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new KmpSearch().kmpSearch("abcaabababaa", "abab"));
        System.out.println(new KmpSearch().kmpSearch("ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
