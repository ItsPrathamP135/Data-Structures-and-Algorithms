package com.problems;

import java.util.Stack;

public class TwoSumSubSet {
	
	public static void getSubSet(int[] arr, Stack<Integer> stk, int i, int target) {
		if(arr.length == 0) {
			System.out.println("No Output");
			return;
		}
		
		if(i == arr.length) {
			return;
		}
		
		if(!stk.isEmpty()) {
			if(arr[stk.peek()] + arr[i] == target) {
				System.out.println("[" + stk.peek() + ", " + i + "]");
				return;
			}
		}
		stk.push(i);
		if(stk.size() == 1) {
			getSubSet(arr, stk, i+1, target);
		}
		stk.pop();
		getSubSet(arr, stk, i+1, target);
		
	}

	public static void main(String[] args) {
		int[] arr = {1, 7, 9, 10};
		Stack<Integer> stk = new Stack<>();
		getSubSet(arr, stk, 0, 16);
		
		

	}

}
