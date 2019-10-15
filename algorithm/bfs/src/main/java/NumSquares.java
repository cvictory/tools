import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cvictory ON 2019-05-19
 */
public class NumSquares {

    public int numSquares(int n) {
        List<Integer> squares = generateSequence(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;

    }

    private List<Integer> generateSequence(int n) {
        int start = 1;
        int diff = 1;
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = start; i < n; i++) {
            nums.add(i);
            diff += 2;
            i += diff;
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
