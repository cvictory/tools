import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-08-03
 */
public class BinaryTreePaths2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new ArrayList<>();
        doBinaryTreePaths(root, r, new StringBuilder(), true);
        return r;
    }

    private void doBinaryTreePaths(TreeNode t, List<String> r, StringBuilder sb, boolean isRoot) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            int l = sb.length();
            if (!isRoot) {
                sb.append("->");
            }
            sb.append(t.val);
            r.add(sb.toString());
            sb.delete(l, sb.length());
            return;
        }
        int l = sb.length();
        if (!isRoot) {
            sb.append("->");
        }
        sb.append(t.val);
        doBinaryTreePaths(t.left, r, sb, false);
        doBinaryTreePaths(t.right, r, sb, false);
        sb.delete(l, sb.length());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.right = new TreeNode(5);
        System.out.println(new BinaryTreePaths2().binaryTreePaths(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
