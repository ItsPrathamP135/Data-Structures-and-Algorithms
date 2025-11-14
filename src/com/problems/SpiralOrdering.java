package com.problems;
import java.util.*;

class SpiralOrdering {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++; // Move the top boundary down

            // Traverse Down
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse Left (Only if a row remains)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse Up (Only if a column remains)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 5, 8},
            {4, 0, -1}
        };

        System.out.println(spiralOrder(matrix)); // Expected Output: [2, 5, 8, -1, 0, 4]
    }
}
