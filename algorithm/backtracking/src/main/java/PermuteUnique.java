import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-08-03
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        doPermuteUnique(nums, new boolean[nums.length], r, new ArrayList<Integer>());
        return r;
    }

    public void doPermuteUnique(int[] nums, boolean[] hasVisited, List<List<Integer>> r, List<Integer> list) {
        if (list.size() == nums.length) {
            r.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) || hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            list.add(nums[i]);
            doPermuteUnique(nums, hasVisited, r, list);
            hasVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}
