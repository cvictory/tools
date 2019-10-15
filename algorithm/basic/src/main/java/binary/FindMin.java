package binary;

/**
 * @author cvictory ON 2019-07-20
 */
public class FindMin {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            }
            if (nums[mid] < nums[h]) {
                h = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
