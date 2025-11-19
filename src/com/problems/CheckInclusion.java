package com.problems;

public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {
	for (int i = 0; i <= s2.length() - s1.length(); i++) {
	    if (isValid(s2.substring(i, i + s1.length()), s1)) {
		return true;
	    }
	}
	return false;
    }

    public static boolean isValid(String strs, String str) {
	int[] freq = new int[128];

	for (char c : strs.toCharArray()) {
	    freq[c]++;
	}

	for (char c : str.toCharArray()) {
	    if (freq[c] == 0) {
		return false;
	    }
	    freq[c]--;
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println(checkInclusion("abc", "lecasbee"));
	System.out.println(checkInclusion("cas", "lecasbee"));
    }

}
