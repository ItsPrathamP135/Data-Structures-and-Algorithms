package com.problems;

import java.util.Arrays;

public class Pattern {
	
	public static int[][] createPattern(int num){
		int[][] array = new int[num][num];
		
		int sequence = 1;
		for(int j = 0; j <= (num*2-2); j++) {
			int row = 0, col = j;
			if(j >= num) {
				col = num -1;
				row = (j%num) + 1;
			}
			
			
			while(row < num && row >= 0 && col < num && col >= 0) {
				array[row][col] = sequence;
				row++;
				col--;
				sequence++;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[][] array = createPattern(4);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

}
