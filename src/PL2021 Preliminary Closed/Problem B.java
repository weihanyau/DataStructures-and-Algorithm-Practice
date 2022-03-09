import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        Queue<int[]> buffer = new LinkedList<>();
        map.put(1,0);
        long sum = 0;
        for(int i = 0; true; i++){
            int n1 = 0;
            int n2 = 0;
            if(i < t - 1){
                n1 = sc.nextInt();
                n2 = sc.nextInt();
                //leaf nodes
                if(!count.containsKey(n1)){
                    count.put(n1, 1);
                }else{
                    count.put(n1, count.get(n1) + 1);
                }

                if(!count.containsKey(n2)){
                    count.put(n2, 1);
                }else{
                    count.put(n2, count.get(n2) + 1);
                }
            } else if(!buffer.isEmpty()){
                int[] n = buffer.remove();
                n1 = n[0];
                n2 = n[1];
            } else{
                break;
            }

            //sum of depth
            if(map.containsKey(n1)){
                map.put(n2, map.get(n1) + 1);
                sum += map.get(n1) + 1;
            } else if(map.containsKey(n2)){
                map.put(n1,map.get(n2) + 1);
                sum += map.get(n2) + 1;
            } else{
                buffer.add(new int[]{n1,n2});
            }


        }

        int leaf = 0;
        for (Map.Entry<Integer,Integer> entry : count.entrySet()) {
            if(entry.getValue() == 1) {
                leaf++;
            }
        }

        System.out.println(sum + " " + leaf);
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