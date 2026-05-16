class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int r=ROWS*COLS-1;
        int l=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int row=mid/COLS;//mid=5
            int col=mid%COLS;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
