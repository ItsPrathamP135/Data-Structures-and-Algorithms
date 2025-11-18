package com.problems;

import java.util.LinkedList;
import java.util.Queue;

public class IslandTreasure {
    public void islandsAndTreasure(int[][] grid) {
	int iL = grid.length, jL = grid[0].length, INF = Integer.MAX_VALUE;;
        int[][] directions = { {0, 1}, {1, 0}, {0,-1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < iL; i++) {
            for(int j = 0; j < jL; j++) {
        	if(grid[i][j] == 0) {
        	    queue.add(new int[]{i, j});
        	}
            }
        }
        
        while(!queue.isEmpty()) {
            int[] list = queue.poll();
            int iN, jN;
            
            for(int[] direct: directions) {
        	iN = list[0] + direct[0];
        	jN = list[1] + direct[1];
        	
        	if(iN >= 0 && iN < iL && jN>=0 && jN < jL && (grid[iN][jN] == INF || grid[iN][jN] > grid[list[0]][list[1]] + 1)) {
        	    grid[iN][jN] = grid[list[0]][list[1]] + 1;
        	    queue.add(new int[]{iN, jN});
        	}
            }
            
        }
     }
    
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        IslandTreasure solution = new IslandTreasure();
        int INF = Integer.MAX_VALUE;

        // Example test case
        int[][] grid = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        System.out.println("Original Grid:");
        printGrid(grid);

        solution.islandsAndTreasure(grid);

        System.out.println("\nModified Grid:");
        printGrid(grid);
    }
}
