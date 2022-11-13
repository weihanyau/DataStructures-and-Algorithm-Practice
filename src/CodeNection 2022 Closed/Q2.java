import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        String input = fr.nextLine();
        char[] c = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(c[i])){
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                map.put(c[i], 1);
            }
        }

        int max = 0;

        for(var entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        System.out.println(n - max);
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