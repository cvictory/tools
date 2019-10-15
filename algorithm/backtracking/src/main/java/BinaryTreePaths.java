import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-21
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        rootNode.left = l1;
        rootNode.right = r1;
        TreeNode lr1 = new TreeNode(5);
        l1.right = lr1;


        System.out.println(new BinaryTreePaths().binaryTreePaths(rootNode));
    }

    /**
     * Input:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * Output: ["1->2->5", "1->3"]
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        collectPaths(root, result, new StringBuilder(""), root.left != null || root.right != null, 0);
        return result;
    }

    private void collectPaths(TreeNode root, List<String> result, StringBuilder strPath, boolean haschild, int i) {

        if (root == null) {
            if (!haschild) {
                result.add(strPath.toString());
            }
            return;
        }
        if (i != 0) {
            strPath.append("->");
        }
        strPath.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(strPath.toString());
            return;
        }
        int origLenght = strPath.length();
        collectPaths(root.left, result, strPath, root.left != null || root.right != null, i + 1);
        if (strPath.length() != origLenght)
            strPath.delete(origLenght, strPath.length());
        collectPaths(root.right, result, strPath, root.left != null || root.right != null, i + 1);
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
