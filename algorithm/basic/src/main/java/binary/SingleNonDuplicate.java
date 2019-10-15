package binary;

/**
 * @author cvictory ON 2019-07-20
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        int mid = 0;
        while (l < h) {
            mid = (l + h) / 2;
            if (mid % 2 == 0) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                h = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                l = mid + 1;
            } else {
                break;
            }
        }
        return nums[h];
    }

    public static void main(String[] args) {
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
