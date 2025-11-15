package com.problems;

public class MinimumWindowString {
    
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        String str = "", strs = "";
        int len = Integer.MAX_VALUE;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
        	strs = s.substring(i,j);
        	if(isPresent(strs, t) && strs.length() < len && t.length() <= strs.length()) {
        	    str = strs;
        	    len = str.length();
        	}
            }
        }
        return str;
    }
    
    public static boolean isPresent(String strs, String subStr) {
	    int[] freq = new int[128]; // Assuming ASCII characters
	    for (char c : strs.toCharArray()) {
	        freq[c]++;
	    }

	    for (char c : subStr.toCharArray()) {
	        if (freq[c] == 0) {
	            return false;
	        }
	        freq[c]--;
	    }
	    return true;
	}


    public static void main(String[] args) {
	System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

    }

}
