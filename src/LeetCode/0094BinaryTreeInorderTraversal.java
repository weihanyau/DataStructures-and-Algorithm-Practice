package LeetCode;
import java.util.*;

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root);
        return ans;
    }

    public void traverse(List<Integer> ans, TreeNode node){
        if(node == null){
            return;
        }

        traverse(ans, node.left);
        ans.add(node.val);
        traverse(ans, node.right);
    }
}
