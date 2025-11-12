package DSA.Arrays.LeetCode;

public class AH_Q88_MergeSortedArrays {

    /**
     * Merges two sorted arrays nums1 and nums2 into nums1 in-place.
     * 
     * Approach: - Start from the end of both arrays to avoid overwriting values in
     * nums1. - Compare elements from the end and place the larger one at the
     * current index. - Continue until all elements from nums2 are merged.
     * 
     * Time Complexity: O(m + n) Space Complexity: O(1) (in-place)
     * 
     * @param nums1 first array with size m + n (extra space at the end)
     * @param m     number of valid elements in nums1
     * @param nums2 second sorted array
     * @param n     number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) { // 0 ms
	// If nums1 has no valid elements, copy all elements from nums2
	if (m == 0) {
	    for (int i = 0; i < n; i++) {
		nums1[i] = nums2[i];
	    }
	    return;
	}

	int index = m + n - 1; // last index of merged array
	m--; // last valid element index in nums1
	n--; // last element index in nums2

	// Merge nums1 and nums2 from the end
	while (n >= 0 && m >= 0) {
	    if (nums1[m] >= nums2[n]) {
		nums1[index] = nums1[m];
		m--;
	    } else {
		nums1[index] = nums2[n];
		n--;
	    }
	    index--;
	}

	// If nums2 still has elements, copy them
	while (n >= 0) {
	    nums1[index] = nums2[n];
	    index--;
	    n--;
	}
    }

    public static void main(String[] args) {
	// Example usage
	AH_Q88_MergeSortedArrays mergeArrays = new AH_Q88_MergeSortedArrays();
	int[] nums1 = { 1, 3, 5, 0, 0, 0 };
	int[] nums2 = { 2, 4, 6 };
	mergeArrays.merge(nums1, 3, nums2, 3);
	for (int num : nums1) {
	    System.out.print(num + " "); // Output: 1 2 3 4 5 6
	}
    }
}
