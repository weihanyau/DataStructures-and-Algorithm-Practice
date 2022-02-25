package LeetCode;
import java.util.*;

class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root);
        return ans;
    }

    public void traverse(List<Integer> ans, TreeNode node){
        if(node == null){
            return;
        }
        ans.add(node.val);
        traverse(ans, node.left);
        traverse(ans, node.right);
    }
}
