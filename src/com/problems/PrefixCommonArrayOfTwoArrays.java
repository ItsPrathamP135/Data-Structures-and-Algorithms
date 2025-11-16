package com.problems;

import java.util.ArrayList;
import java.util.Arrays;

// LeetCode 2657
public class PrefixCommonArrayOfTwoArrays {
	
	public static int[] getCommonPrefix(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) {
			return null;
		}
		
		int[] arr = new int[arr1.length];
		ArrayList<Integer> list1 = new ArrayList<>(),
						   list2 = new ArrayList<>();
		int previous = 0;
		
		
		for(int i = 0; i < arr.length; i++) {
			if(arr1[i] == arr2[i]) {
				previous++;
				arr[i] = previous;
			}else {
				if(list2.contains(arr1[i])) {
					previous++;
					list2.remove((Integer)arr1[i]);
					
				}else {
					list1.add(arr1[i]);
				}
	
				
				if(list1.contains(arr2[i])) {
					previous++;
					list1.remove((Integer)arr2[i]);
				}else {
					list2.add(arr2[i]);
				}
				arr[i] = previous;
			}	
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,3,2,4},
			  arr2 = {3,1,2,4};
		
		System.out.println(Arrays.toString(getCommonPrefix(arr1,arr2)));

	}

}
