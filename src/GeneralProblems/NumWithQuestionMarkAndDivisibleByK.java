package GeneralProblems;

public class NumWithQuestionMarkAndDivisibleByK{
    public static int DivisibleByK(String s, int k){
        int questionMark = 0;
        boolean first = s.toCharArray()[0] == '?';

        for(char c : s.toCharArray()){
            if(c == '?'){
                questionMark++;
            }
        }
        int[] num = new int[questionMark];
        if(first){
            num[0] = 1;
        }
        int total = 0;
        total += Permute(num, 0, s, k);
        return total;
    }
    public static int Permute(int[] num, int index, String s, int k){
        int total = 0;
        if(index == num.length){
            //System.out.println(Arrays.toString(num));
            String sub = s;
            for(int i : num){
                sub = sub.replaceFirst("[?]", String.valueOf(i));
            }
            if(Integer.parseInt(sub) % k == 0){
                return 1;
            }
            return 0;
        } else{
            for (int i = num[index]; i < 10; i++) {
                total += Permute(num, index + 1, s, k);
                num[index]++;
            }
            num[index] = 0;
        }
        return total;
    }
}
