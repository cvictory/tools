import java.util.Arrays;

/**
 * @author cvictory ON 2019-07-24
 */
public class QuickSort {

    private static int[] quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void doQuickSort(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start + 1, j = end;
        while (i < j) {
            while (j > start && nums[j] > base) {
                j--;
            }
            while (i < end && nums[i] < base) {
                i++;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }
        int target = Math.min(i, j);
        swap(nums, target, start);
        print(nums);
        if (start < target -1) {
            doQuickSort(nums, start, target - 1);
        }
        if (target + 1 < end) {
            doQuickSort(nums, target + 1, end);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        print(quickSort(new int[]{49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22}));
        print(quickSort(new int[]{-1, 1, 0}));
    }

    private static void print(int[] nums) {
        for (int r : nums) {
            System.out.print(r);
            System.out.print(" , ");
        }
        System.out.println("");
    }
}
