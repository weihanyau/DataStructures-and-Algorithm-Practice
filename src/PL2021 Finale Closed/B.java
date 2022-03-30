import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int a = fr.nextInt();
        int b = fr.nextInt();
        int n = fr.nextInt();
        int gcd = gcd(a,b);
        int max = a + b;
        int reject = 0;
        for(int i = 0; i < n; i++) {
            int req = fr.nextInt();
            if(req > max){
                reject++;
                continue;
            }
            if(req % gcd != 0){
                reject++;
            }
        }
        System.out.println(reject);
    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
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