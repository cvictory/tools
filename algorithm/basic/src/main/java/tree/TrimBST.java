package tree;

/**
 * @author cvictory ON 2019-07-25
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val > R){
            return trimBST(root.left, L, R);
        }else if(root.val<L){
            return trimBST(root.right, L, R);
        }
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        root.left = left;
        root.right = right;
        return root;
    }
}
