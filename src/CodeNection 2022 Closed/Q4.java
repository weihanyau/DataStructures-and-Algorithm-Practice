import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int t = fr.nextInt();

        for (int i = 0; i < t; i++) {
            int n = fr.nextInt();
            //System.out.println(n);
            if (n == 0) {
                System.out.println("YES");
                continue;
            }
            String s = fr.nextLine();
            String check = "YES";
            String[] splits = s.split("\\*");
            //System.out.println(Arrays.toString(splits));
            if (splits.length == 0) {
                System.out.println("YES");
                continue;
            }
            for (String split : splits) {
                if (split.length() == 0) {
                    continue;
                }
                if (split.length() == 1) {
                    check = "NO";
                    break;
                }

                int num1 = 0;
                int num0 = 0;
                char[] charArray = split.toCharArray();
                for (char c : charArray) {
                    if (c == '1') {
                        num1++;
                    } else if (c == '0') {
                        num0++;
                    }
                }
                if (num1 >= split.length() || num0 >= split.length()) {
                    check = "NO";
                    break;
                }
            }
            System.out.println(check);
        }
    }

    static void validate(String s, int n) {
        String check = "YES";

        if (s.contains("*1*") || s.contains("*0*") || s.length() == 1) {
            System.out.println("NO");
            return;
        }

        if (s.length() == 2) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("NO");
                return;
            }
        }

        if (s.substring(0, 2).contains("1*") || s.substring(0, 2).contains("0*")) {
            check = "NO";
        }

        if (s.substring(s.length() - 2).contains("*0") || s.substring(s.length() - 2).contains("*1")) {
            check = "NO";
        }

        System.out.println(check);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {return Integer.parseInt(next());}

        long nextLong() {return Long.parseLong(next());}

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}