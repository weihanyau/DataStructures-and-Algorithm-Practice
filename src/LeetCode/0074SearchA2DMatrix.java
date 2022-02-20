package LeetCode;

class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int possibleRow = start;
        while(start <= end){
            int mid = (start + end) / 2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] < target){
                start = mid + 1;
                possibleRow = mid;
            }
            if(matrix[mid][0] > target){
                end = mid - 1;
            }
        }
        int columnStart = 0;
        int columnEnd = matrix[possibleRow].length - 1;
        while(columnStart <= columnEnd){
            int mid = (columnStart + columnEnd) / 2;
            if(matrix[possibleRow][mid] == target){
                return true;
            }
            if(matrix[possibleRow][mid] < target){
                columnStart = mid + 1;
            }
            if(matrix[possibleRow][mid] > target){
                columnEnd = mid - 1;
            }
        }
        return false;
    }
}
