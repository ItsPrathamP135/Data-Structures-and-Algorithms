package com.problems;

import java.util.Arrays;

public class patternsPrint {
	
	public static int[][] patterns(int num){
		if(num <= 0) {
			return null;
		}
		
		int[][] arr = new int[num][];
		arr[0] = new int[1];
		arr[0][0] = 1;
		
		int index = 1, values = 0, difference = 1, previous = 3, counts = -1;
		
		while(index < num) {
			arr[index] = new int[index+1];
			int count = 0;
			values = previous - difference;
			while(count < index+1) {
				arr[index][count] = values;
				previous = values;
				values += 2;
				count++;
			}	
			counts++;
			
			if(counts == 2) {
				difference += 2;
				counts = 0;
			}	
			index++;
		}
		
		for(int[] a: arr) {
			System.out.println(Arrays.toString(a));
		}
		return arr;
	
	}

	public static void main(String[] args) {
		patterns(8);
	}

}


