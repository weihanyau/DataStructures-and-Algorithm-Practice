import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        String input = fr.nextLine();
        char[] c = input.toCharArray();
        char[] t = {'F', 'C', 'I'};
        long[][] dp = new long[n + 1][3 + 1];

        //base cases
        for (int i = 0; i <= 3; i++)
            dp[0][i] = 0;

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        //fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (c[i - 1] == t[j - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[n][3]);
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