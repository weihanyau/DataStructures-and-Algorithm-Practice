package LeetCode;
import java.util.*;

class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int[] dir = {0 , -1, 0, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                } else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i < dir.length - 1; i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                if(nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length || mat[nr][nc] != -1){
                    continue;
                }
                mat[nr][nc] = mat[r][c] + 1 ;
                q.add(new int[]{nr, nc});
            }
        }
        return mat;
    }
}
