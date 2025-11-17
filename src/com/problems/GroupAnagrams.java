package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> mainList = new ArrayList<List<String>>();
		List<String> subList = new ArrayList<String>();
		char[] arr, arrs;
		
		for(int i = 0; i < strs.length; i++) {
			subList.clear();
			if(strs[i] != null) {
				subList.add(strs[i]);
				arr = strs[i].toCharArray();
				Arrays.sort(arr);
				strs[i] = null;
				for(int j = i+1; j < strs.length; j++) {
					if(strs[j] != null) {
						arrs = strs[j].toCharArray();
						Arrays.sort(arrs);
						if(Arrays.equals(arr, arrs)) {
							subList.add(strs[j]);
							strs[j] = null;
						}
					}
				}
				mainList.add(new ArrayList<>(subList));
			}	
		}
		return mainList;
	}

	public static void main(String[] args) {
		String[] strs={"act","pots","tops","cat","stop","hat"};
		groupAnagrams(strs);
	}

}
