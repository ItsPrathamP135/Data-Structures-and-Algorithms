package com.problems;

import java.util.Arrays;

public class ABCPatterns {

    public static char[][] getPattern(int num) {
	char[][] arr = new char[num][];
	int count = 1;

	for (int i = 0; i < num; i++) {
	    arr[i] = new char[i + 1];

	    for (int j = 0; j < arr[i].length; j++) {
		if (i % 2 == 0) {
		    if (j % 2 == 0) {
			arr[i][j] = (char) (count + 64);
		    } else {
			arr[i][j] = (char) (count + 96);
		    }
		} else {
		    if (j % 2 == 0) {
			arr[i][j] = (char) (count + 96);
		    } else {
			arr[i][j] = (char) (count + 64);
		    }
		}
		count++;
	    }
	}
	return arr;
    }

    public static void main(String[] args) {
	char[][] arrs = getPattern(4);

	for (char[] a : arrs) {
	    System.out.println(Arrays.toString(a));
	}
	System.out.println("");

	char[][] arr = getPattern(5);

	for (char[] a : arr) {
	    System.out.println(Arrays.toString(a));
	}
    }
}
