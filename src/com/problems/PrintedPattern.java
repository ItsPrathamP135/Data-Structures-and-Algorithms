package com.problems;

public class PrintedPattern {
	
	public static void printsPattern(String strs) {
		int num = strs.length() + strs.length() - 1, 
			mid = strs.length()/2,
			digit = 1;
		
		
		while(num > 0 && digit <= strs.length()) {
			String str = getSpace(num-1);
			int len = 0;
			while(len < digit) {
				str += strs.charAt(mid+len);
				len++;
				int index = (mid+len)%strs.length();
				while(index < mid && len < digit) {
					str += strs.charAt(index);
					len++;
					index++;
				}
			}
			System.out.println(str);
			digit++;
			num -= 2;
		}
	}
	
	public static String getSpace(int num) {
		String strs = "";
		
		while(num>0) {
			strs += " ";
			num--;
		}
		return strs;
	}

	public static void main(String[] args) {
		printsPattern("PROGRAM");
	}

}







