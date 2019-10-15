import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-07-20
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            pos[chars[i] - 'a'] = i;
        }
        int end = pos[chars[0] - 'a'];
        int start = 0;
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (end < i || i == chars.length - 1) {
                r.add(end - start + 1);
                end = pos[chars[i] - 'a'];
                start = i;
                continue;
            }
            end = Math.max(pos[chars[i] - 'a'], end);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
