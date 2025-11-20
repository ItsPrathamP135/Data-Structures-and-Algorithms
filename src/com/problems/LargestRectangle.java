package com.problems;

import java.util.Arrays;

// Different Method is also available

public class LargestRectangle {

    public static int getAreaOfRectangle(int[] arr) {
	int area = 0, min = 0;

	for (int i = 1; i < arr.length; i++) {
	    for (int j = 0; j < arr.length - i; j++) {
		min = getMin(Arrays.copyOfRange(arr, j, j + i));
		if ((min * i) > area) {
		    area = min * i;
		}
	    }
	}
	return area;
    }

    public static int getMin(int[] arr) {
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < arr.length; i++) {
	    if (min > arr[i]) {
		min = arr[i];
	    }
	}

	return min;
    }

    public static void main(String[] args) {
	int[] arr = { 2, 1, 5, 6, 2, 3 };
	System.out.println(getAreaOfRectangle(arr));
    }

}
