import java.util.*;
import java.io.*;

class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        long a = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            char[] chars = fr.nextLine().toCharArray();
            int mid = chars.length / 2;
            int sumLeft = 0;
            int sumRight = 0;
            for (int c = 0; c < mid; c++) {
                sumLeft += chars[c] - 'A';
            }
            for (int c = mid; c < chars.length; c++) {
                sumRight += chars[c] - 'A';
            }
            System.out.println(sumLeft);
            System.out.println(sumRight);
            char[] ans = new char[chars.length/2];
            for (int c = 0; c < mid; c++) {
                chars[c] = (char) (((chars[c] + sumLeft - 'A') % 26) + 'A');
                chars[c + mid] = (char) (((chars[c + mid] + sumRight - 'A') % 26) + 'A');
                ans[c] = (char) (((chars[c] + chars[c + mid] - 'A' - 'A') % 26) + 'A');
            }
            String s = new String(ans);
            System.out.println(s);
        }
        long b = System.currentTimeMillis();
        System.out.println("Time taken: " + (b-a));
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