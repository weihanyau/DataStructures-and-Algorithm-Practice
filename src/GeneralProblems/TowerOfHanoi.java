package GeneralProblems;

import java.util.*;

class TowerOfHanoi {
    public static void main(String[] args) {
        Stack<Integer> start = new Stack<>();
        Stack<Integer> other = new Stack<>();
        Stack<Integer> end = new Stack<>();
        for(int i = 4; i >= 1; i--){
            start.add(i);
        }
        hanoi(4, start, end, other, start, end, other);
    }

    public static void hanoi(int n, Stack<Integer> start, Stack<Integer> end, Stack<Integer> other, Stack<Integer> startCopy, Stack<Integer> endCopy, Stack<Integer> otherCopy){
        if(n == 1){
            end.add(start.pop());
            System.out.printf("\n%s\n%s\n%s\n", startCopy, otherCopy, endCopy);
        } else{
            hanoi(n - 1, start, other, end, startCopy, endCopy, otherCopy);
            end.add(start.pop());
            System.out.printf("\n%s\n%s\n%s\n", startCopy, otherCopy, endCopy);
            hanoi(n - 1, other, end, start, startCopy, endCopy, otherCopy);
        }
    }
}