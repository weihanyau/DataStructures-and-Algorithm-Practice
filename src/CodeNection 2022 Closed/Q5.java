import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();

        long[] suffixSum = new long[n + 1];
        suffixSum[n - 1] = a[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            suffixSum[j] = suffixSum[j + 1] + a[j];
        }

        long max = Long.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if(a[i] > max){
                max = Math.max(a[i], max);
                maxIdx = i;
            }


        }
        System.out.println(maxSubArraySum(suffixSum, maxIdx + 1));
    }

    public static long maxSubArraySum(long[] a, int size) {
        long max_so_far = Integer.MIN_VALUE;
        long max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i] - a[size];
            max_so_far = Math.max(max_ending_here, max_so_far);
            max_ending_here = Math.max(0, max_ending_here);
        }
        return max_so_far;
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