package com.problems;

import java.util.Arrays;
import java.util.Scanner;

public class LadderProblem {
    static Scanner sc = new Scanner(System.in);

    public static String[] getPattern(int num) {
	String[] arr = new String[num];
	Arrays.fill(arr, "");
	int count = 1;
	for (int i = 0; i < num; i++) {
	    for (int j = i; j < num; j++) {
		arr[j] = count + " " + arr[j];
		count++;
	    }
	}
	return arr;
    }

    public static void main(String[] args) {
	System.out.println("Enter the number you want");
	int num = sc.nextInt();
	String[] arr = getPattern(num);

	for (String str : arr) {
	    System.out.println(str);
	}
    }
}
