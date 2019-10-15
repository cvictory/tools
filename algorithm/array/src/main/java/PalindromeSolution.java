/**
 * @author cvictory ON 2019-04-16
 */
public class PalindromeSolution {

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s == e || s + 1 == e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abdcda"));
        System.out.println(validPalindrome("abcda"));
    }
}
