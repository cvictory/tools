import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-21
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        doCombine(list, new ArrayList<>(), n, k, 0);
        return list;
    }

    private void doCombine(List<List<Integer>> list, List<Integer> singleList, int n, int k, int start) {
        if (singleList.size() == 2) {
            list.add(new ArrayList<>(singleList));
            return;
        }
        for (int i = start; i < n; i++) {
            singleList.add(i + 1);
            doCombine(list, singleList, n, k, i + 1);
            singleList.remove(singleList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
        System.out.println(new Combinations().combine2(4, 2));
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        doCombine2(list, new ArrayList<>(), n, k, 0);
        return list;
    }

    private void doCombine2(List<List<Integer>> list, List<Integer> tmp, int n, int k, int start) {
        if (k == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < n; i++) {
            tmp.add(i + 1);
            doCombine2(list, tmp, n, k - 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
