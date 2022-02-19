package LeetCode;
import java.util.*;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= numRows - 1; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    int a = ans.get(i - 1).get(j - 1);
                    int b = ans.get(i - 1).get(j);
                    row.add(a + b);
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
