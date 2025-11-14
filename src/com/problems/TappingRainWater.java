package com.problems;

import java.util.ArrayList;
import java.util.List;


public class TappingRainWater {
	
	public static int getTotalBars(int[][] arr) {
		ArrayList<Integer> towers = new ArrayList<>();
		int initial = 0,volume = 0, initialIndex = 0;
				
		for(int j = 0; j < arr[0].length; j++) {
			int height = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i][j] == 1) {
					height++;
				}
			}
			towers.add(height);
			
			
			if(initial == 0 && height > 0) {
				initial = height;
				initialIndex = j;
			}
		}
		
		// Remove columns before the first tower if the few towers doesn't exists before so removing indexes
		towers = new ArrayList<>(towers.subList(initialIndex, towers.size()));
		

		if(initial == 0) {
			return 0;
		}else {
			return calculateVolume(towers, initial, volume);
		}
	}
	
	
	public static int calculateVolume(ArrayList<Integer> arr, int initial, int volume) {
		int count = 1, next = 0, index = 0;
		
		
		while(count < arr.size() && initial > next) {
			if(next < arr.get(count)) {
				next = arr.get(count);
				index = count;
			}
			count++;
		}
		
		
		if(next == 0 || index == 0) {
			return volume;
		}else {
			volume += getVolume(initial, next, index-1, arr.subList(1, index));
			 arr = new ArrayList<>(arr.subList(index, arr.size()));
			return calculateVolume(arr, next, volume);
		}
	}
	
	public static int getVolume(int initial, int next, int length, List<Integer> arr) {
		int volume = (initial > next ? next : initial) * length, 
			subtract = 0;
		
		for(int a: arr) {
			subtract += a;
		}
		
		return (volume - subtract);
	}

	public static void main(String[] args) {
//		int[][] array = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//		                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//		                 {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
//		                 {1, 1, 0, 0, 0, 0, 1, 1, 0, 1},
//		                 {1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
//		                 {1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
//		                 {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
//		                 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
		
		int[][] array = { {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
	                 	  {0, 1, 0, 1, 0, 0, 0, 1, 1, 0},
	                 	  {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}};
		
		System.out.println("Volume of water get stored :- " + getTotalBars(array));
	}

}
