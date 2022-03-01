package LeetCode;
import java.util.*;

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int prev = list.get(0);
        for(int i = 1; i < list.size(); i++){
            int curr = list.get(i);
            if(prev >= curr){
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}
