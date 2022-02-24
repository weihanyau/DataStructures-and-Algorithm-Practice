package LeetCode;
import java.util.*;

class MyQueue {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        peek();
        return b.pop();
    }

    public int peek() {
        if(b.empty()){
            while(!a.empty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.empty() && b.empty();
    }
}
