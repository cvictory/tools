import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-21
 */
public class Permutations {
    /**
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        doPermutations(list, new ArrayList<>(), nums, visited, 0);
        return list;
    }

    private void doPermutations(List<List<Integer>> list, List<Integer> integers, int[] nums, boolean[] visited, int numCount) {
        if (numCount == nums.length) {
            list.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited[i]) {
                continue;
            }
            integers.add(num);
            visited[i] = true;
            doPermutations(list, integers, nums, visited, numCount + 1);
            integers.remove(integers.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{3, 5, 7, 9}));

        System.out.println(new Permutations().permute2(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute2(new int[]{3, 5, 7, 9}));
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        doIt(r, new ArrayList<>(), nums, visited);
        return r;
    }

    private void doIt(List<List<Integer>> r, List<Integer> tmp, int[] nums, boolean[] visited){
        if(tmp.size() == nums.length){
            r.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=0; i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            doIt(r, tmp, nums, visited);
            tmp.remove(tmp.size() -1);
            visited[i] = false;
        }
    }
}
