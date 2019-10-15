import com.sun.tools.javac.jvm.Gen;
import javafx.collections.transformation.TransformationList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cvictory ON 2019-07-20
 */
public class GenerateTrees {

    public static void main(String[] args) {
        System.out.println(new GenerateTrees().generateTrees(3));
        System.out.println(new GenerateTrees().generateTrees(3).size());
    }

    public List<TreeNode> generateTrees(int n) {
        int[] r = generateNum(n);
        return generate(r, 0, n - 1);
    }

    private List<TreeNode> generate(int[] r, int s, int e) {
        if (s > e) {
            return null;
        }
        if (s == e) {
            return Arrays.asList(new TreeNode(r[s]));
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generate(r, s, i - 1);
            List<TreeNode> right = generate(r, i + 1, e);
            if (left == null) {
                for (TreeNode singleRight : right) {
                    TreeNode m = new TreeNode(r[i]);
                    m.right = singleRight;
                    result.add(m);
                }
                continue;
            }
            if (right == null) {
                for (TreeNode singLeft : left) {
                    TreeNode m = new TreeNode(r[i]);
                    m.left = singLeft;
                    result.add(m);
                }
                continue;
            }
            for (TreeNode singleLeft : left) {
                for (TreeNode singleRight : right) {
                    TreeNode m = new TreeNode(r[i]);
                    result.add(m);
                    m.left = singleLeft;
                    m.right = singleRight;
                }
            }
        }
        return result;
    }

    private int[] generateNum(int n) {
        int[] r = new int[n];
        for (int i = 1; i <= n; i++) {
            r[i - 1] = i;
        }
        return r;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "\r\n\t /" + left + "  \\" + right;
        }
    }
}
