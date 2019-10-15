/**
 * @author cvictory ON 2019-07-23
 */
public class MinPath {

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public int minDistance2(String word1, String word2) {
        return word1.length() + word2.length() - 2 * sameNum(word1, word2, 0, 0);
    }

    private int sameNum(String word1, String word2, int s1, int s2) {
        int sameNum = 0;
        for (int i = s1; i < word1.length(); i++) {
            for (int j = s2; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    sameNum++;
                } else {
                    sameNum += Math.max(sameNum(word1, word2, s1 + 1, s2), sameNum(word1, word2, s1, s2 + 1));
                }
            }
        }
        return sameNum;
    }

    public static void main(String[] args) {
        System.out.println(new MinPath().minDistance("sea", "eat"));
        System.out.println(new MinPath().minDistance2("sea", "eat"));
    }
}
