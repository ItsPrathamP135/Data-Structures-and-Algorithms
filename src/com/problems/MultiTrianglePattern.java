package com.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pairs {
    int i, j;
    String direction;

    public Pairs(int i, int j, String direction) {
        this.i = i;
        this.j = j;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "[" + i + ", " + j + "]";
    }
}

public class MultiTrianglePattern {

    public static String[][] getPattern(int num) {
        String[][] arr = new String[num][num * 2 - 1];
        boolean[][] check = new boolean[num][num * 2 - 1];

        // Initialize arrays
        for (String[] a : arr) {
            Arrays.fill(a, " ");
        }
        for (boolean[] a : check) {
            Arrays.fill(a, false);
        }

        Queue<Pairs> queue = new LinkedList<>();
        check[0][num - 1] = true;
        queue.add(new Pairs(0, num - 1, "Both"));

        while (!queue.isEmpty()) {
            Pairs pair = queue.remove();
            String direction = pair.direction;
            int i = pair.i, j = pair.j;

            // Process 'Both' direction
            if (direction.equals("Both") && check[i][j] && i + 1 < num && j + 1 < num * 2 - 1 && j - 1 >= 0) {
                arr[i][j] = "*";

                queue.add(new Pairs(i + 1, j + 1, "Right"));
                check[i + 1][j + 1] = !check[i + 1][j + 1]; // Toggle

                queue.add(new Pairs(i + 1, j - 1, "Left"));
                check[i + 1][j - 1] = !check[i + 1][j - 1]; // Toggle

            // Process 'Right' direction
            } else if (direction.equals("Right")) {
                arr[i][j] = "*";
                if (i % 4 == 3) {
                    arr[i][j - 2] = "*";
                }
                if (i + 1 < num && j + 1 < num * 2 - 1) {
                    queue.add(new Pairs(i + 1, j + 1, (i + 1) % 4 == 0 ? "Both" : "Right"));
                    check[i + 1][j + 1] = !check[i + 1][j + 1]; // Toggle
                }

            // Process 'Left' direction
            } else if (direction.equals("Left")) {
                arr[i][j] = "*";
                if (i % 4 == 3) {
                    arr[i][j + 2] = "*";
                }
                if (i + 1 < num && j - 1 >= 0) {
                    queue.add(new Pairs(i + 1, j - 1, (i + 1) % 4 == 0 ? "Both" : "Left"));
                    check[i + 1][j - 1] = !check[i + 1][j - 1]; // Toggle
                }
            }
        }
        return arr;
    }

    public static void printPattern(String[][] array) {
        for (String[] row : array) {
            for (String val : row) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a power of 2 (e.g., 2, 4, 8, 16, ...): ");
        int num = sc.nextInt(), temp = num;
        
        while(true) {
            if(temp%2==0 && temp!=0) {
        	if(temp == 2) {
        	    break;
        	}
        	temp /= 2;
            }else {
        	System.out.println("Invalid input! Please enter a number that is a power of 2.");
        	num = sc.nextInt();
        	temp = num;
            }

        }
        
        
        String[][] arr = getPattern(num);
        printPattern(arr);
    }
}
