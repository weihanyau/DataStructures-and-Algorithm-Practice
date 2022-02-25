package LeetCode;
import java.util.*;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[] dir = {0, -1 , 0, 1, 0};
        Queue<int[]> currQ = new LinkedList<>();
        Queue<int[]> nextQ = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) currQ.add(new int[]{i, j});
            }
        }
        int time = 0;
        while(!currQ.isEmpty()){
            int[] curr = currQ.remove();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i < dir.length - 1; i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1) continue;
                grid[nr][nc] = 2;
                nextQ.add(new int[]{nr, nc});
            }
            if(currQ.isEmpty() && !nextQ.isEmpty()){
                time++;
                Queue<int[]> temp = currQ;
                currQ = nextQ;
                nextQ = temp;
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return time;
    }
}
