package tree;

/**
 * @author cvictory ON 2019-07-25
 */
public class ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        doConvertBST(root);
        return root;
    }

    private void doConvertBST(TreeNode root) {
        if (root == null) {
            return;
        }
        doConvertBST(root.right);
        root.val = root.val + sum;
        sum += root.val;
        doConvertBST(root.left);
    }
}
