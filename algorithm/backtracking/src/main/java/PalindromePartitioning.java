import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-22
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        doPartition(result, new ArrayList<String>(), s, 0, 0);
        return result;
    }

    private void doPartition(List<List<String>> result, List<String> partitionData, String s, int start, int numCount) {
//        System.out.println(start + " , " + numCount);
        if (numCount == s.length()) {
            result.add(new ArrayList<>(partitionData));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                partitionData.add(s.substring(start, i + 1));
                doPartition(result, partitionData, s, i + 1, numCount + i - start + 1);
                partitionData.remove(partitionData.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (begin == end) {
            return true;
        }
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
}
