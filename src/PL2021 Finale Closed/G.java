import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        long[] dp = new long[1000001];
        for(int i = 1; i <= 1000000; i++) {
            if(isPrime(i)){
                dp[i] += dp[i - 1];
            } else{
                dp[i] = dp[i - 1] + i;
            }
        }
        for(int i = 0; i < n; i++){
            a[i] = fr.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = fr.nextInt();
        }
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += dp[b[i]] - dp[a[i] - 1];
        }
        System.out.println(sum);
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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