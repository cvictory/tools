import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cvictory ON 2019-07-21
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        List<String> sourceList = new LinkedList<>(wordList);
        q.add(beginWord);
        int length = 1;
        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            while (--size >= 0) {
                String cur = q.poll();
                Iterator<String> iterator = sourceList.iterator();
                while (iterator.hasNext()) {
                    String t = iterator.next();
                    if (isConnect(t, cur)) {
                        if (endWord.equals(t)) {
                            return length;
                        }
                        iterator.remove();
                        q.add(t);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    public static void main(String[] args) {
        System.out.println(new LadderLength().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new LadderLength().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}
