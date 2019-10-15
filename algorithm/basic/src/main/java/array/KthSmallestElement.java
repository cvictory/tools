package array;

import java.util.PriorityQueue;

/**
 * @author cvictory ON 2019-05-29
 */
public class KthSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<EleData> priorityQueue = new PriorityQueue<>();
        for (int j = 0; j < matrix[0].length; j++) {
            priorityQueue.offer(new EleData(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            EleData e = priorityQueue.poll();
            if (e.x == matrix.length - 1) continue;
            priorityQueue.offer(new EleData(e.x + 1, e.y, matrix[e.x + 1][e.y]));
        }
        return priorityQueue.poll().value;
    }

    static class EleData implements Comparable<EleData> {
        int x;
        int y;
        int value;

        public EleData(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(EleData o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElement().kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
    }
}
