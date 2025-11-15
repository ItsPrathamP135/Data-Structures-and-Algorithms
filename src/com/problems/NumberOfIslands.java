package com.problems;

import java.util.Stack;

class Paired{
	int i, j;

	public Paired(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
}

public class NumberOfIslands {
	
	public static int getNumberOfIslands(int[][] arr) {
		int numberOfIslands = 0;
		Stack<Paired> stk = new Stack<>();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					stk.push(new Paired(i, j));
					arr[i][j] = -1;
					
					
					while(!stk.isEmpty()) {
						Paired pair = stk.pop();
						
						if(pair.i > 0 && arr[pair.i-1][pair.j] == 1) {
							stk.push(new Paired(pair.i-1, pair.j));
							arr[pair.i-1][pair.j] = -1;
						}
						
						if(pair.j > 0 && arr[pair.i][pair.j-1] == 1) {
							stk.push(new Paired(pair.i, pair.j-1));
							arr[pair.i][pair.j-1] = -1;
						}
						
						if(pair.i < arr.length - 1 && arr[pair.i+1][pair.j] == 1) {
							stk.push(new Paired(pair.i+1, pair.j));
							arr[pair.i+1][pair.j] = -1;
						}
						
						if(pair.j < arr[0].length-1 && arr[pair.i][pair.j+1] == 1) {
							stk.push(new Paired(pair.i, pair.j+1));
							arr[pair.i][pair.j+1] = -1;
						}
					}
					numberOfIslands++;
					
				}
			}
		}	return numberOfIslands;
	}

	public static void main(String[] args) {
        int[][] array = {
                {0, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 0, 1}	};
        System.out.println(getNumberOfIslands(array) );
	}

}
