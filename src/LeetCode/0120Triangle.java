package LeetCode;
import java.util.*;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int curr = triangle.get(i).get(j);
                int last1 = j == 0 ? Integer.MAX_VALUE : triangle.get(i - 1).get(j - 1);
                int last2 = j == (triangle.get(i).size() - 1) ? Integer.MAX_VALUE : triangle.get(i - 1).get(j);
                if(j == 0){
                    triangle.get(i).set(j, last2 + curr);
                } else if (j == (triangle.get(i).size() - 1)){
                    triangle.get(i).set(j, last1 + curr);
                } else{
                    triangle.get(i).set(j, Math.min(last1, last2) + curr);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
        }

        return min;
    }
}
