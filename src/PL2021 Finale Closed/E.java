import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        char[][] maze = new char[n][m];

        for(int i = 0; i < n; i++) {
            String row = fr.nextLine();
            maze[i] = row.toCharArray();
        }
        int minStartToExit = Integer.MAX_VALUE;
        int minTeleporterToExit = Integer.MAX_VALUE;
        int minStartToTeleporter = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 'S'){
                    minStartToExit = toExit(maze, j, i, new boolean[n][m]);
                    minStartToTeleporter = toTeleporter(maze, j, i, new boolean[n][m]);
                }
                if(maze[i][j] == 'E'){
                    minTeleporterToExit = toTeleporter(maze, j, i, new boolean[n][m]);
                }
            }
        }
        if(minStartToExit != Integer.MAX_VALUE && minTeleporterToExit != Integer.MAX_VALUE && minStartToTeleporter != Integer.MAX_VALUE){
            System.out.println(Math.min(minStartToTeleporter + minTeleporterToExit, minStartToExit));
        } else if(minStartToExit != Integer.MAX_VALUE){
            System.out.println(minStartToExit);
        } else if(minStartToTeleporter != Integer.MAX_VALUE && minTeleporterToExit != Integer.MAX_VALUE){
            System.out.println(minStartToTeleporter + minTeleporterToExit);
        } else{
            System.out.println(-1);
        }
    }

    public static int toExit(char[][] maze, int x, int y, boolean[][] check){
        int[] dir = {0,1,0,-1,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.remove();
                int currX = curr[0];
                int currY = curr[1];
                if(!(currX < 0 || currY < 0 || currX == maze[0].length || currY == maze.length || check[currY][currX] || maze[currY][currX] == '#' )){
                    check[currY][currX] = true;
                    if(maze[currY][currX] == 'E'){
                        return distance;
                    }
                    for(int j = 0; j < dir.length - 1; j++){
                        queue.add(new int[]{currX + dir[j], currY + dir[j + 1]});
                    }
                }
            }
            distance++;
        }
        return Integer.MAX_VALUE;
    }

    public static int toTeleporter(char[][] maze, int x, int y, boolean[][] check){
        int[] dir = {0,1,0,-1,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.remove();
                int currX = curr[0];
                int currY = curr[1];
                if(!(currX < 0 || currY < 0 || currX == maze[0].length || currY == maze.length || check[currY][currX] || maze[currY][currX] == '#')){
                    check[currY][currX] = true;
                    if(maze[currY][currX] == 'O'){
                        return distance;
                    }
                    for(int j = 0; j < dir.length - 1; j++){
                        queue.add(new int[]{currX + dir[j], currY + dir[j + 1]});
                    }
                }
            }
            distance++;
        }
        return Integer.MAX_VALUE;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}