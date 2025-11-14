package com.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {
	
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[k];
        int temp = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		temp = map.getOrDefault(nums[i], 0) + 1;
        		map.replace(nums[i], temp);
        	}else {
        		map.put(nums[i], 1);
        	}
        }
        temp = 0;
       
        List<Map.Entry<Integer, Integer>> sortedMap =  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());;
        for (int i = 0; i < k; i++) {
            array[i] = sortedMap.get(i).getKey(); // Store element, not frequency
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,4,3,3,3};
		topKFrequent(nums, 2);

	}

}
