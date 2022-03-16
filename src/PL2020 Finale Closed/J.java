import java.util.*;
import java.io.*;

class Scratch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        long a = System.currentTimeMillis();
        int blank = 0;
        while(blank <= n) {
            String line = fr.nextLine();
            if(line.isBlank()){
                blank++;
                System.out.println();
            } else{
                String[] s = line.split(" ");
                StringBuffer ans = new StringBuffer();
                int index = 0;
                for (String value : s) {
                    if (index < value.length()) {
                        ans.append(value.charAt(index));
                        index++;
                    }
                }
                System.out.println(ans);
            }
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