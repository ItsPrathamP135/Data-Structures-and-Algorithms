package com.problems;

public class LongestPalindrome {
    
    public static String longestPalindrome(String s) {
        String maxString = "";
        
        for(int i = 0; i < s.length(); i++) { // j = i is done because it may contain a string with length 1
            for(int j = i; j < s.length(); j++) {
        	if(s.charAt(i) == s.charAt(j)) {
        	    if(checkPalindrome(s.substring(i,j+1))) {
        		if(s.substring(i,j+1).length() > maxString.length()) {
        		    maxString = s.substring(i,j+1);
        		}
        	    }
        	}
            }
        }
        
        return maxString;
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
	System.out.println(longestPalindrome("abbc"));
    }
    

}
