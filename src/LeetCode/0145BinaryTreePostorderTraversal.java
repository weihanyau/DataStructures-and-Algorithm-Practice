package LeetCode;
import java.util.*;

class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root);
        return ans;
    }

    public void traverse(List<Integer> ans, TreeNode node){
        if(node == null){
            return;
        }
        traverse(ans, node.left);
        traverse(ans, node.right);
        ans.add(node.val);
    }
}
