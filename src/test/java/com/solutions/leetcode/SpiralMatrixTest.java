package com.solutions.leetcode;

import java.util.*;

public class SpiralMatrixTest {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m*n;
        List<Integer> result = new ArrayList<>(size);

        int firstRow = 0;
        int firstCol = 0;
        int lastRow = m-1;
        int lastCol = n-1;
        while(result.size()<size){
            // TO-RIGHT
            for(int i = firstCol; i <= lastCol;i++){
                result.add(matrix[firstRow][i]);
            }
            firstRow++;
            if(result.size()>=size) break;

            // TO-DOWN
            for(int i = firstRow; i <= lastRow; i++){
                result.add(matrix[i][lastCol]);
            }
            lastCol--;
            if(result.size()>=size) break;

            // TO-LEFT
            for(int i = lastCol; i >= firstCol; i--){
                result.add(matrix[lastRow][i]);
            }
            lastRow--;
            if(result.size()>=size) break;

            // TO-UP
            for(int i = lastRow; i>= firstRow; i--){
                result.add(matrix[i][firstCol]);
            }
            firstCol++;
            if(result.size()>=size) break;
        }


        return result;
    }
}
