package LeetCode;
import java.util.*;

class PopulatingNextRightPointersInEachNode {
    //My iterative solution with stack
    public Node connect(Node root) {
        Queue<Node> currentQueue = new LinkedList<>();
        Queue<Node> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while(currentQueue.peek() != null){
            Node currNode = currentQueue.remove();
            currNode.next = currentQueue.peek();
            if(currNode.left != null){
                nextQueue.add(currNode.left);
            }
            if(currNode.right != null){
                nextQueue.add(currNode.right);
            }
            if(currentQueue.peek() == null){
                Queue<Node> temp = currentQueue;
                currentQueue = nextQueue;
                nextQueue = temp;
            }
        }
        return root;
    }

    //Easy to understand recursive solution
    public Node connectEfficient(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
