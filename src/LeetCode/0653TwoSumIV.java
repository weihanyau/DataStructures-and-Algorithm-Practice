package LeetCode;

import java.util.HashSet;

class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return inorderTraversal(root, set, k);
    }

    public boolean inorderTraversal(TreeNode node, HashSet<Integer> set, int k){
        if(node == null){
            return false;
        }
        if(set.contains(k - node.val)){
            return true;
        }
        set.add(node.val);
        return inorderTraversal(node.left, set, k) || inorderTraversal(node.right, set, k);
    }
}
