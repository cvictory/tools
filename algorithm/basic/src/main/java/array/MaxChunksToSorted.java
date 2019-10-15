package array;

/**
 * @author cvictory ON 2019-07-26
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int count = 0, lastPos = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (lastPos <= num) {
                count++;
            }
            if (num > lastPos) {
                lastPos = num;
            }
        }
        return count++;
    }

    public static void main(String[] args) {
        System.out.println(new MaxChunksToSorted().maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(new MaxChunksToSorted().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
