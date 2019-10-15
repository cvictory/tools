package tree;

/**
 * @author cvictory ON 2019-07-25
 */
public class HasPathSum {


    public boolean hasPathSum2(PathSum.TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        if(hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum- root.val)){
            return true;
        }
        return false;
    }
}
