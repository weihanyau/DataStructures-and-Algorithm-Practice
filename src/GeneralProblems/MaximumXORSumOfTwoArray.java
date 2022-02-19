package GeneralProblems;

public class MaximumXORSumOfTwoArray {
    public static int MaxXORSum(int[] a, int[] b){
        return MaxXOR(a, b, 0);
    }

    public static int MaxXOR(int[] a, int[] b, int index){
        int max = 0, carry = 0;
        if (index >= a.length){
            int sum = 0;
            for(int i = 0; i < a.length; i++){
                sum += a[i] ^ b[i];
            }
            return sum;
        } else {
            for(int i = index; i < a.length; i++){
                int temp = b[index];
                b[index] = b[i];
                b[i] = temp;
                carry = MaxXOR(a, b, index + 1);
                if(carry > max){
                    max = carry;
                }
                temp = b[index];
                b[index] = b[i];
                b[i] = temp;
            }
            return max;
        }
    }
}
