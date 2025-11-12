package DSA.Arrays.LeetCode;

public class BC_Q121_StockBuySell {

    /**
     * Finds the maximum profit from buying and selling stock once.
     * 
     * Approach: - Track the least price seen so far. - Track the maximum price
     * after the least to calculate profit. - Update max profit whenever a higher
     * profit is found.
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     * 
     * @param prices array of stock prices
     * @return maximum profit
     */
    public static int maxProfit(int[] prices) { // 1ms
	int profit = 0; // maximum profit found so far
	int max = 0; // current maximum price after least
	int least = prices[0]; // minimum price so far

	for (int i = 0; i < prices.length; i++) {
	    if (least > prices[i]) {
		// Found new minimum price, reset max
		least = prices[i];
		max = 0;
	    } else if (max < prices[i] && (profit < (prices[i] - least))) {
		// Found a higher price that gives better profit
		profit = prices[i] - least;
		max = prices[i];
	    }
	}

	return profit; // return the maximum profit achievable
    }

    public static void main(String[] args) {
	// Test case
	int[] prices = { 7, 1, 5, 3, 6, 4 };
	System.out.println(maxProfit(prices)); // Output: 5
    }
}
