import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[][] seq = new int[n][2];
        for(int i = 0; i < n; i++) {
            seq[i][0] = fr.nextInt();
            seq[i][1] = fr.nextInt();
        }
        Arrays.sort(seq, Comparator.comparingInt(a -> a[0]));
        int curr = 0;
        int move = 0;
        for(int i = 0; i < n; i++) {
            int start = seq[i][0] - 1;
            int end = seq[i][1];
            curr = (start - curr) % x == 0 ? start : start - (start - curr) % x;
            if(curr < 0) curr = 0;
            move += (end - curr);
            curr = end;
        }
        System.out.println(move);
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