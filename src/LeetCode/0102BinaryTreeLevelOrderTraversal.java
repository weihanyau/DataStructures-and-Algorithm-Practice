package LeetCode;
import java.util.*;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()){
            int currLevel = q.size();
            List<Integer> currLevelValue = new ArrayList<>();
            for(int i = 0; i < currLevel; i++){
                TreeNode curr = q.remove();
                currLevelValue.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(currLevelValue);
        }
        return result;
    }
}
