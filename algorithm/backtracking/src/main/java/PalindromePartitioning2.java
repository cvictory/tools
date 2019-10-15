import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-08-03
 */
public class PalindromePartitioning2 {

    public List<List<String>> partition(String s) {
        List<List<String>> r = new ArrayList<List<String>>();
        doPartition(s, r, new ArrayList<>());
        return r;
    }

    public void doPartition(String s, List<List<String>> r, List<String> list) {
        if (s.isEmpty()) {
            r.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                System.out.println(s + " , " + i + " , ");
                list.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), r, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int s, int e) {
        char[] cc = str.toCharArray();
        if (cc.length <= e) {
            return false;
        }
        while (s <= e) {
            if (cc[s++] == cc[e--]) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().partition("aab"));
    }
}
