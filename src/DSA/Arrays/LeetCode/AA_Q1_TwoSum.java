package DSA.Arrays.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AA_Q1_TwoSum {

    /**
     * Brute-force approach: O(n^2) Loops through all pairs to find indices whose
     * values sum to target
     */
    public static int[] twoSum(int[] nums, int target) { // 44
	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length; j++) {
		if (nums[i] + nums[j] == target) {
		    return new int[] { i, j }; // return indices when sum matches target
		}
	    }
	}
	return null; // return null if no pair found
    }

    /**
     * Streams + Map approach: O(n) Uses Java Streams to create a map of number ->
     * index
     */
    public int[] twoSumStreams(int[] nums, int target) { // 10
	// Create a map: number -> last occurrence index
	Map<Integer, Integer> newMap = IntStream.range(0, nums.length).boxed()
		.collect(Collectors.toMap(i -> nums[i], i -> i, (oldVal, newVal) -> newVal // keep last index if
											   // duplicate
		));

	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    // Check if complement exists and is not the same index
	    if (newMap.containsKey(complement) && newMap.get(complement) != i) {
		return new int[] { i, newMap.get(complement) };
	    }
	}

	return null; // return null if no pair found
    }

    /**
     * Optimized HashMap approach: O(n) Iterates once and checks complement in map
     */
    public int[] twoSumStreamsEfficient(int[] nums, int target) { // 2
	Map<Integer, Integer> newMap = new HashMap<>();

	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    if (newMap.containsKey(complement)) {
		return new int[] { newMap.get(complement), i }; // found the pair
	    }
	    newMap.put(nums[i], i); // store current number with its index
	}

	return null; // return null if no pair found
    }

    public static void main(String[] args) {
	// Test the brute-force method
	int[] result = twoSum(new int[] { 3, 2, 4 }, 6);
	System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}
