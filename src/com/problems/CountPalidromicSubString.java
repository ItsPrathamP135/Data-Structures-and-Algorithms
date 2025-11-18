package com.problems;

public class CountPalidromicSubString {
    
    public static int countSubstrings(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
        	if(s.charAt(i) == s.charAt(j)) {
        	    if(checkPalindrome(s.substring(i, j+1))) {
        		count++;
        	    }
        	}
            }
        }
        return count;
    }
    
    public static boolean checkPalindrome(String str) {
	for(int i = 0; i < str.length()/2; i++) {
	    if(str.charAt(i) != str.charAt((str.length() - i - 1))){
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	 String s = "aabaac";
	 System.out.println("Palindromic substrings count: " + countSubstrings(s)); // Output: 10

    }

}
