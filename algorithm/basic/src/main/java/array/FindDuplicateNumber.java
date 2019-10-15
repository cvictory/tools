package array;

/**
 * @author cvictory ON 2019-05-30
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
//            System.out.println(slow);
            slow = nums[slow];
            if(fast == 6){
                fast = 0;
            }
            fast = nums[nums[fast]];
        }
        int restart = 0;
//        System.out.println("---" + slow);
        while (restart != slow) {
            restart = nums[restart];
            if(slow == 6){
                slow = 0;
            }
            slow = nums[slow];
        }
        return slow;
    }

    public int findDuplicate0(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            if(fast == 6){
                fast = 0;
            }
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if(fast == 6){
                fast = 0;
            }
            if(slow == 6){
                slow = 0;
            }
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int findDuplicate3(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
//        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
//        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        System.out.println(new FindDuplicateNumber().findDuplicate2(new int[]{1, 3, 4, 2, 2}));
//        System.out.println(new FindDuplicateNumber().findDuplicate2(new int[]{3, 1, 3, 4, 2}));

        System.out.println(new FindDuplicateNumber().findDuplicate0(new int[]{4, 1, 4, 5, 2}));
        System.out.println(new FindDuplicateNumber().findDuplicate0(new int[]{5, 1, 3, 1, 4, 6}));


        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{4, 1, 3, 4, 2}));
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{5, 1, 3, 1, 4, 6}));
        System.out.println(new FindDuplicateNumber().findDuplicate3(new int[]{4, 1, 3, 4, 2}));
        System.out.println(new FindDuplicateNumber().findDuplicate3(new int[]{5, 1, 3, 1, 4, 6}));
    }
}
