import java.util.Arrays;
import java.util.List;

/**
 * @author cvictory ON 2019-07-23
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    boolean dfs(String s, List<String> wordDict, int start) {

        if (start > s.length()) {
            return false;
        }
        if (start == s.length()) {
            return true;
        }

        for (String word : wordDict) {
            if (start + word.length() > s.length() || !s.substring(start, start + word.length()).equals(word)) {
                continue;
            }
            if (dfs(s, wordDict, start + word.length())) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int l = word.length();
                if (l <= i && word.equals(s.substring(i - l, i))) {
                    dp[i] = dp[i] || dp[i - l];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

        System.out.println(new WordBreak().wordBreak2("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak2("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
