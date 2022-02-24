package LeetCode;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int baseColor = image[sr][sc];
        if(baseColor == newColor){
            return image;
        }
        dfs(image, sr, sc, baseColor, newColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int baseColor,int newColor){

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != baseColor) return;
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, baseColor,newColor);
        dfs(image, sr + 1, sc, baseColor,newColor);
        dfs(image, sr, sc - 1, baseColor,newColor);
        dfs(image, sr, sc + 1, baseColor,newColor);
    }
}
