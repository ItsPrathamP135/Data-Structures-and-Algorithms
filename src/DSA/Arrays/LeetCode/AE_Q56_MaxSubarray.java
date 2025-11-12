package DSA.Arrays.LeetCode;

public class AE_Q56_MaxSubarray {

    /**
     * Finds the maximum sum of a contiguous subarray using Kadane's Algorithm.
     * 
     * Approach: - Maintain a running sum (total) of the current subarray. - Reset
     * total to 0 if it becomes negative (start new subarray). - Track the largest
     * single element in case all numbers are negative. - Update the maximum
     * subarray sum found so far (returns).
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     * 
     * @param nums input array
     * @return maximum sum of contiguous subarray
     */
    public static int maxSubArray(int[] nums) { // 1ms
	int total = 0; // current running sum
	int returns = 0; // maximum sum found so far
	int largest = nums[0]; // largest single element in case all are negative

	for (int i = 0; i < nums.length; i++) {
	    total += nums[i]; // add current element to running sum
	    largest = (largest < nums[i]) ? nums[i] : largest; // track largest element
	    if (total < 0) {
		total = 0; // reset if sum is negative
	    }

	    if (total > returns) {
		returns = total; // update maximum sum
	    }
	}

	// If all numbers are negative, return the largest element
	return (returns == 0) ? largest : returns;
    }

    public static void main(String[] args) {
	int[] nums = { 4, -5, 4, 3, 7, 8, -10 };
	System.out.println(maxSubArray(nums)); // Output: 22
    }
}
