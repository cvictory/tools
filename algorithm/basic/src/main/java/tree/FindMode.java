package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-07-25
 */
public class FindMode {
    int max = 0;
    List<Integer> r = new ArrayList<Integer>();
    public Integer[] findMode(TreeNode root) {
        doFindMode(root);
        findMode(root.left);
        findMode(root.right);
        return (Integer[]) r.toArray();
    }

    public void doFindMode(TreeNode root) {
        if(root == null) return;
        int v = 1;
        if(root.left != null && root.val == root.left.val){
            v++;
            doFindMode(root.left);
        }
        if(root.right != null && root.val == root.right.val){
            v++;
            doFindMode(root.right);
        }
        if(v == max){
            r.add(root.val);
        }else if(v >= max){
            max = v;
            r.clear();
            r.add(root.val);
        }
    }
}
