import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-21
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        doSum(new ArrayList<>(), combinations, 0, 0, target, candidates);
        return combinations;
    }

    private void doSum(List<Integer> integers, List<List<Integer>> combinations, int sum, int pos, int target, int[] candidates) {
        if (sum == target) {
            combinations.add(new ArrayList<Integer>(integers));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            integers.add(candidates[i]);
            doSum(integers, combinations, sum + candidates[i], i, target, candidates);
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        doSum(combinations, new ArrayList<>(), target, candidates, 0);
        return combinations;
    }

    private void doSum(List<List<Integer>> combinations, List<Integer> tmp, int restSum, int[] candidates, int s) {
        if (restSum == 0) {
            combinations.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (restSum < candidates[i]) {
                continue;
            }
            restSum = restSum - candidates[i];
            tmp.add(candidates[i]);
            doSum(combinations, tmp, restSum, candidates, i);
            restSum = restSum + candidates[i];
            tmp.remove(tmp.size() - 1);
        }
    }
}
