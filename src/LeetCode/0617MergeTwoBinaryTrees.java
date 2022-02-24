package LeetCode;

class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null){
            return null;
        }
        if(tree1 == null){
            return tree2;
        }
        if(tree2 == null){
            return tree1;
        }
        tree1.val += tree2.val;
        tree1.left = mergeTrees(tree1.left, tree2.left);
        tree1.right = mergeTrees(tree1.right, tree2.right);
        return tree1;
    }
}
