package com.problems;

import java.util.Scanner;

public class StarPatternLeftAngledTriangle {
	static Scanner sc = new Scanner(System.in);	
	
	public static void printPattern(int num) {
		String str = "";
		for(int i = 1; i <= num; i++) {
			str = "";
			for(int j = 1; j <= num; j++) {
				if(i == num || j == num || j >= (num - i + 1)) {
					str += " *";
				}else {
					str += "  ";
				}
			}
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the square length you want");
		printPattern(sc.nextInt());
	}

}
