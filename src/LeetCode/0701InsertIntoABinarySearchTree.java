package LeetCode;

class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode head = root;
        while(root != null){
            if(val < root.val && root.left != null){
                root = root.left;
            } else if(val >= root.val && root.right != null){
                root = root.right;
            } else if(val < root.val){
                root.left = new TreeNode(val);
                break;
            } else{
                root.right = new TreeNode(val);
                break;
            }
        }
        return head;
    }
}
