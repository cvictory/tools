import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cvictory ON 2019-07-20
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                if (o1[1] < o2[1]) {
                    return -1;
                }
                return o2[0] - o1[0];
            }
        });
        int t = 0, e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < e) {
                t++;
                continue;
            }
            e = intervals[i][1];
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));
        System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(new int[][]{
                {1, 2}, {1, 2}, {1, 2}
        }));
    }
}
