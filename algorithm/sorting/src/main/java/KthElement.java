import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cvictory ON 2019-07-20
 */
public class KthElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null || o2 == 0) {
                    return 0;
                } else if (o1 == null) {
                    return 1;
                } else if (o2 == null) {
                    return -1;
                }
                if (o1 == o2) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int num : nums) {
            priorityQueue.add(num);
        }

        for (int i = 1; i < k; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int r = nums.length - k;
        int i = 0, j = nums.length;
        while (true) {
            int m = quickSort(nums, i, j);
//            System.out.println(m);
            if (m == r) {
                return nums[m];
            } else if (m > r) {
                j = m;
            } else {
                i = m + 1;
//                r = r - i;
            }
        }
    }

    private int quickSort(int[] nums, int l, int h) {
        int i = l, j = h;
        while (true) {
            while (nums[++i] < nums[l] && i < h) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new KthElement().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new KthElement().findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));

        System.out.println(Integer.toString(100, 7));
    }



}
