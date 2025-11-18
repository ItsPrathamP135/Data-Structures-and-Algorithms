package com.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInWater {
    
    public static int swimInWater(int[][] grid) {
        // Possible directions to move: right, down, left, up
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int maxHeight = 0;  // Track the maximum height encountered on the path
        int iL = grid.length, jL = grid[0].length;  // Grid dimensions
        
        // Track visited cells to prevent re-processing
        boolean[][] isVisited = new boolean[iL][jL];
        
        // Min-Heap (Priority Queue) to always process the lowest elevation first
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Start from (0,0)
        queue.add(new int[] {grid[0][0], 0, 0});
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // Get the cell with the smallest elevation
            
            maxHeight = Math.max(maxHeight, current[0]);  // Update maxHeight
            
            // If we reached the bottom-right corner, return the required time
            if (current[1] == iL - 1 && current[2] == jL - 1) {
                return maxHeight;
            }
            
            // Explore all four possible movements
            for (int[] direct : directions) {
                int iN = current[1] + direct[0], jN = current[2] + direct[1];

                // Check if within bounds and not visited
                if (iN >= 0 && iN < iL && jN >= 0 && jN < jL && !isVisited[iN][jN]) {
                    queue.add(new int[] {grid[iN][jN], iN, jN});
                    isVisited[iN][jN] = true;  // Mark as visited
                }
            }
        }
        
        return -1;  // Should never be reached
    }

    public static void main(String[] args) {
        // Example Test Case (can be modified for testing)
        int[][] grid = {
            {0, 2, 4},
            {3, 5, 8},
            {1, 6, 7}
        };
        
        int result = swimInWater(grid);
        System.out.println("Minimum time to swim: " + result);  // Expected output: 7
    }
}
