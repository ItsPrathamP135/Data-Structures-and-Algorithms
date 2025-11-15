package com.problems;


public class Matrix90DegreeRotation {
    
    public static int[][] getMatrix(int[][] matrix){
	int temp;
	System.out.println("The entered matrix is :-");
	printMatrix(matrix);
	
	for(int i = 0; i < matrix.length; i++) {
	    for (int j = i + 1; j < matrix[0].length; j++) { // Fix: Start from j = i + 1
	        temp = matrix[i][j];
	        matrix[i][j] = matrix[j][i];
	        matrix[j][i] = temp;
	    }
	}
	
	
	for(int[] arr: matrix) {
	    for(int i = 0; i < arr.length/2; i++) {
		temp = arr[i];
		arr[i] = arr[arr.length-1-i];
		arr[arr.length-1-i] = temp;
	    }
	}
	
	System.out.println("The new matrix is :-");
	printMatrix(matrix);
	
	return matrix;
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
	            {4, 5, 6},
	            {7, 8, 9}
	        };
	getMatrix(matrix);
    }

}
