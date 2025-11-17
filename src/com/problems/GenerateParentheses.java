package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] arr = new char[n*2];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = '(';
        	arr[i+n] = ')';
        }
        
        getPermutation(arr, 0, list);
        return list;
    }
    
    public static void getPermutation(char[] arr, int index, List<String> list){
	
	if(arr.length == index && isValid(arr, index)) {
	    String does = String.valueOf(arr);
	    if(!list.contains(does)) {
		list.add(does);
	    }
	}
	
	for(int i = index; i < arr.length; i++) {
	    if(!isValid(arr, index)) {
		continue;
	    }
	    
	    char temp = arr[index];
	    arr[index] = arr[i];
	    arr[i] = temp;
	    getPermutation(arr, index+1, list);
	    arr[i] = arr[index];
	    arr[index] = temp;
	}
    }
    
    public static boolean isValid(char[] arr, int index) {
	Stack<Character> stk = new Stack<>();
	for(int i = 0; i < index; i++) {
	    if(arr[i] == '(') {
		stk.push('(');
	    }else {
		if(stk.isEmpty()) {
		    return false;
		}else {
		    stk.pop();
		}
	    }
	}
	return true;
    }
    

    public static void main(String[] args) {
	System.out.println(generateParenthesis(6));;
    }

}
