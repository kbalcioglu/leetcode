package com.solutions.leetcode;

public class SetMatrixZerosTest {
    public void setZeroes(int[][] matrix) {

        int firstRowStats = 1;

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRowStats = 0;
                        matrix[0][j] = 0;
                    }
                    else{
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int r = 1;r<matrix.length;r++ ){
            for(int c = 1; c< matrix[0].length; c++){
                if(matrix[0][c] == 0 || matrix[r][0] == 0){
                    matrix[r][c] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int r = 0;r<matrix.length;r++ ){
                matrix[r][0] = 0;
            }
        }
        if(firstRowStats == 0){
            for(int c = 0;c<matrix[0].length;c++ ){
                matrix[0][c] = 0;
            }
        }

    }
}
