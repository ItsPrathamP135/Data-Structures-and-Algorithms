package DSA.Arrays.LeetCode;

public class AC_Q26_RemoveDuplicates {

    /**
     * Removes duplicates from a sorted array in-place.
     * 
     * Approach: - Use two pointers technique. - 'start' points to the position to
     * insert the next unique element. - Iterate through the array and copy unique
     * elements forward.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     * 
     * @param nums sorted input array
     * @return the length of array after removing duplicates
     */
    public static int removeDuplicates(int[] nums) {
	if (nums.length == 0) {
	    return 0; // empty array case
	}

	int start = 1; // next position to insert unique element
	for (int i = 1; i < nums.length; i++) {
	    if (nums[i] != nums[i - 1]) {
		nums[start] = nums[i]; // move unique element to 'start' index
		start++;
	    }
	}

	return start; // length of array with unique elements
    }

    public static void main(String[] args) {
	// Test case
	int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
	int length = removeDuplicates(nums);
	System.out.println("Length after removing duplicates: " + length);

	// Optional: print unique elements
	for (int i = 0; i < length; i++) {
	    System.out.print(nums[i] + " "); // Output: 0 1 2 3 4
	}
    }
}
