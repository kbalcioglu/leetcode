package com.solutions.leetcode;

public class RotateImageTest {

    public void rotate(int[][] matrix) {
        int n = matrix.length -1;
        int left = 0;
        int right = n;

        while(left<right){
            int k = right - left;
            for(int i = 0 ; i<k; i++){
                int top = left;
                int bottom = right;

                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            right--;
            left++;
        }
    }
}
