package com.problems;

import java.util.Scanner;
import java.util.Stack;

// Input:- 3[a]2[bc] --> aaabcbc
// Input:- 3[a2[c]] --> accaccacc
// Input:- 3[ab2[c][d]] --> abccdabccdabccd
// Input:- 2[2[b][c]] --> bbcbbc

public class ParenthesesProblems {
    static Scanner sc = new Scanner(System.in);
    public static String getFinalString(String strs) {
	Stack <String> stkstr = new Stack<>();
	Stack <Character> stkbrc = new Stack<>();
	Stack <Integer> stknum = new Stack<>();
	int i = 0, num;
	String mainStr = "", trial;
	
	while(i < strs.length()) {
	    if(Character.isDigit(strs.charAt(i))) {
		num = i;
		while(i < strs.length()) {
		    i++;
		    if(!Character.isDigit(strs.charAt(i)) || strs.charAt(i) == '[' || strs.charAt(i) == ']') {
			break;
		    }
		}
		stknum.push(Integer.parseInt(strs.substring(num, i)));
		
	    }else if(strs.charAt(i) == '[') {
		stkbrc.push(strs.charAt(i));
		if(i > 0) {
		    if(!Character.isDigit(strs.charAt(i-1))) {
			stknum.push(1);
		    }
		}
		i++;
	    }else if(strs.charAt(i) == ']') {

		stkbrc.pop();
		trial = getString(stknum.pop(), stkstr.pop());
		if(stkbrc.isEmpty()) {
		    mainStr = mainStr + trial;
		    
		}else {
		    if(stkstr.isEmpty()) {
			stkstr.push(trial);
		    }else {
			trial = stkstr.pop() + trial;
			stkstr.push(trial);
		    }
		}
		i++;
	    }else {
		num = i;
		while(i < strs.length()) {
		    i++;
		    if(Character.isDigit(strs.charAt(i)) || strs.charAt(i) == '[' || strs.charAt(i) == ']') {
			break;
		    }
		}
		    stkstr.push(strs.substring(num, i));
	    }
	}
	return mainStr;
    }
    
    public static boolean isValid(String str) {
	Stack<Character> stk = new Stack<>();
	
	// Check contains only digits, alphabets, and square brackets
	if(!str.matches(("[a-zA-Z0-9\\[\\]]+"))) {
	    return false; 
	}
	
	for(int i = 0; i< str.length(); i++) {
	    if(str.charAt(i) == '[') {
		stk.push('[');
	    }else if(str.charAt(i) == ']') {
		if(i < str.length()-1 && Character.isLetter(str.charAt(i+1))) {
		    if(Character.isLetter(str.charAt(i+1))){
			    return false;
		    }
		}

		if(stk.isEmpty()) {
		    return false;
		}
		stk.pop();
	    } else if(Character.isDigit(str.charAt(i)) && i < str.length()-1 && Character.isLetter(str.charAt(i+1))) {
		return false;
	    }
	}
	if(!stk.isEmpty()) {
	    return false;
	}else {
	    return true;
	}
    }
    
    public static String getString(int a, String str) {
	String strs = "";
	
	for(int i = 0; i < a; i++) {
	    strs += str;
	}
	return strs;
    }

    public static void main(String[] args) {
	System.out.println("Please Enter the pattern you want");
	String str = sc.next();
	
	while(true) {
	    if(isValid(str)) {
		break;
	    }else {
		System.out.println("Invalid input please try again");
		str = sc.next();
	    }
	}
	System.out.println("The final String of " + str + " is " + getFinalString(str));
    }

}
