package LeetCode;

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r * c != mat.length * mat[0].length){
            return mat;
        }
        int[][] ans = new int[r][c];
        int ptrM1 = 0, ptrN1 = 0, ptrM2 = 0, ptrN2 = 0;
        for(int i = 0; i < r*c; i++){
            if(ptrN1 >= mat[ptrM1].length){
                ptrN1 = 0;
                ptrM1++;
            }
            if(ptrN2 >= c){
                ptrN2 = 0;
                ptrM2++;
            }
            ans[ptrM2][ptrN2] = mat[ptrM1][ptrN1];
            ptrN1++;
            ptrN2++;
        }
        return ans;
    }

    //Cleaner Version with divide and modulus
    public int[][] matrixReshapeCleaner(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
}
