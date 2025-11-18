package com.problems;

import java.util.Arrays;

public class SetZerosMatrix {
    
    public static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length], 
        	cols = new boolean[matrix[0].length];
        
        Arrays.fill(rows, false);
        Arrays.fill(cols, false);
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
        	if(matrix[i][j] == 0) {
        	    rows[i] = true;
        	    cols[j] = true;
        	}
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
        	if(rows[i] || cols[j]) {
        	    matrix[i][j] = 0;
        	}
            }
        }
        
        printMatrix(matrix);
    }
    
    public static void printMatrix(int[][] matrix) {
	for(int i = 0; i < matrix.length; i++) {
	    for(int j = 0; j < matrix[0].length; j++) {
		System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println("");
	}
	System.out.println(" ");
    }

    public static void main(String[] args) {
	int[][] matrix = {
	            {1, 2, 3},
	            {4, 0, 6},
	            {7, 8, 9}
	        };
	setZeroes(matrix);
    }

}
