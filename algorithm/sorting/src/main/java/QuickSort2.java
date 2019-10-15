/**
 * @author cvictory ON 2019-08-01
 */
public class QuickSort2 {

    public static int[] quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void doQuickSort(int[] nums, int s, int e) {
        int first = nums[s];
        int i = s + 1, j = e;
        while (i < j) {
            while (i <= j && nums[j] > first) {
                j--;
            }
            while (i < j && nums[i] < first) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (j > s) {
            swap(nums, s, j);
        }

        print(nums);
        if (s < j - 1) {
            doQuickSort(nums, s, j - 1);
        }
        if (j + 1 < e) {
            doQuickSort(nums, j + 1, e);
        }

    }

    private static void doQuickSort2(int[] nums, int l, int h) {
        int first = nums[l];
        int i = l, j = h;
        while (i < j) {
            while (nums[++i] < nums[l] && i < h) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        if (j > l) {
            swap(nums, l, j);
        }

        print(nums);
        if (l < j - 1) {
            doQuickSort2(nums, l, j - 1);
        }
        if (j + 1 < h) {
            doQuickSort2(nums, j + 1, h);
        }

    }

    private static int quickSort2(int[] nums, int l, int h) {
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

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
