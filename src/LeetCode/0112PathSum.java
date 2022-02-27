package LeetCode;

class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode currNode, int currSum, int targetSum){
        if(currNode == null) return false;
        currSum += currNode.val;
        if(currNode.left == null && currNode.right == null && currSum == targetSum){
            return true;
        }
        return dfs(currNode.left, currSum, targetSum) || dfs(currNode.right, currSum, targetSum);
    }
}
