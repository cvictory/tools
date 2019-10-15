import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author cvictory ON 2019-05-19
 */
public class MinPathLength {
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * [[1,1,0,1],
     * [1,0,1,0],
     * [1,1,1,1],
     * [1,0,1,1]]
     *
     * @param grids
     * @param tr
     * @param tc
     * @return
     */
    public static int minPathLength(int[][] grids, int tr, int tc) {

        Queue<ValuePair> nextRun = new LinkedList<ValuePair>();
        nextRun.add(new ValuePair(0, 0));
        int pathLength = 0;
        int rowCount = grids.length;
        int columnCount = grids[0].length;
        while (!nextRun.isEmpty()) {
            pathLength++;
            int size = nextRun.size();
            while (--size >= 0) {
                ValuePair v = nextRun.poll();
                for (int[] direction : directions) {
                    int curRow = v.row + direction[0];
                    int curColumn = v.column + direction[1];
                    if (curRow < 0 || curRow >= rowCount || curColumn < 0 || curColumn >= columnCount || grids[curRow][curColumn] == 0) {
                        continue;
                    } else if (curRow == tr && curColumn == tc) {
                        return pathLength;
                    }
                    nextRun.add(new ValuePair(curRow, curColumn));
                }
            }
        }
        return 0;
    }

    public static int minPathLengthTest(int[][] grids, int tr, int tc) {

        boolean[][] visited = new boolean[grids.length][grids[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int path = 0;
        while (!queue.isEmpty()) {
            path ++;
            int size = queue.size();
            while(--size >= 0) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];
                    if (row < 0 || row >= grids.length || col < 0 || col >= grids[0].length || grids[row][col] == 0) {
                        continue;
                    }
                    if (row == tr && col == tc) {
                        return path;
                    }
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] directions = {{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}};
//        System.out.println(minPathLength(directions, 1, 2));
        System.out.println(minPathLength(directions, 2, 2));
        System.out.println(minPathLengthTest(directions, 2, 2));
    }

    static class ValuePair {
        public int row;
        public int column;

        public ValuePair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
