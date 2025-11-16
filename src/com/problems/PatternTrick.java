package com.problems;

import java.util.Scanner;

public class PatternTrick {
	static Scanner sc = new Scanner(System.in);
	
	public static String[] getPattern(int num) {
		String str = "", arr[] = new String[num];
		int val = 1, increment = 3, newVal, count = 0;
		for(int i = 0; i < num; i++) {
			str = "";
			if(i==0) {
				val = 1;
			}else if(count == 0) {
				val += increment;
				count++;
			}else {
				val += increment;
				count = 0;
				increment += 2;
			}
			newVal = val;
			for(int j = 0; j <= i; j++) {
				if(j==0) {
					str = newVal + "";
				}else {
					newVal -= 2;
					str = newVal + " " + str;
				}
			}
			arr[i] = str;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println("Please enter the number you want");
		int num = sc.nextInt();
		String[] arrays = getPattern(num);
		int len = arrays[arrays.length-1].length(), space = 0;
		for(int i = 0; i < arrays.length; i++) {
			space = len - arrays[i].length();
			String str = "";
			while(space!=0) {
				str += " ";
				space--;
			} str += arrays[i];
			arrays[i] = str;
		}
		
		for(String str:arrays) {
			System.out.println(str);
		}
	}

}
