import java.util.*;
import java.io.*;

class Coordinates{
    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Coordinates other = (Coordinates) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
}

class Scratch {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        for(int i = 0 ; i < t; i++){
            int ans = 0;
            int n = scanner.nextInt();
            HashSet<Coordinates>  set = new HashSet<>();
            Coordinates[] points = new Coordinates[n];
            for(int j = 0; j < n; j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Coordinates point = new Coordinates(x,y);
                points[j] = point;
                set.add(point);
            }
            for(int j = 0; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    int x1 = points[j].getX();
                    int y1 = points[j].getY();
                    int x2 = points[k].getX();
                    int y2 = points[k].getY();
                    if(x1 == x2 || y1 == y2){
                        continue;
                    }
                    if(set.contains(new Coordinates(x1, y2)) && set.contains(new Coordinates(x2, y1))){
                        ans++;
                    }
                }
            }
            System.out.println(ans/2);
        }
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