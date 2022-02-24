package LeetCode;

class MaxAreaOfAnIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] visited = new boolean[rl][cl];
        int max = 0;
        for(int i = 0; i < rl; i++){
            for(int j = 0; j < cl; j++){
                if(visited[i][j]){
                    continue;
                }
                max = Math.max(max, dfs(grid, visited, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int sr, int sc){
        int rl = grid.length;
        int cl = grid[0].length;
        if(sr < 0 || sc < 0 || sr >= rl || sc >= cl || grid[sr][sc] == 0 || visited[sr][sc]) return 0;
        visited[sr][sc] = true;
        int area = 1;
        area += dfs(grid, visited, sr - 1, sc);
        area += dfs(grid, visited, sr + 1, sc);
        area += dfs(grid, visited, sr, sc - 1);
        area += dfs(grid, visited, sr, sc + 1);
        return area;
    }
}
