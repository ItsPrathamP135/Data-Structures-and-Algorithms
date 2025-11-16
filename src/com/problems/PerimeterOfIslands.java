package com.problems;

public class PerimeterOfIslands {
	
	
//	This is also correct one but more complex and big
//	public static int getPerimeter(int[][] arr) {
//		int perimeter = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[0].length; j++) {
//				if(arr[i][j] == 1) {
//					if(i==0 && j==0) {
//						perimeter += 2;
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//					}else if(i==0 && j==arr[0].length-1) {
//						perimeter += 2;
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}else if(i==arr.length-1 && j==0) {
//						perimeter += 2;
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//					}else if(i==arr.length-1 && j==arr[0].length-1) {
//						perimeter += 2;
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}else if(i==0) {
//						perimeter += 1;
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}else if(j==0) {
//						perimeter += 1;
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//					}else if(i==arr.length-1) {
//						perimeter += 1;
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}else if(j==arr[0].length-1) {
//						perimeter += 1;
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}else {
//						if(arr[i-1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j+1] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i+1][j] == 0) {
//							perimeter += 1;
//						}
//						if(arr[i][j-1] == 0) {
//							perimeter += 1;
//						}
//					}
//				}
//			}
//		}
//		return perimeter;
//	}
	

//	This is also correct one and less complex but can be improved
//	public static int getPerimeter(int[][] arr) {
//		int perimeter = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[0].length; j++) {
//				if(arr[i][j] == 1) {
//						
//						if(i>0) {
//							if(arr[i-1][j] == 0) {
//								perimeter += 1;
//							}
//						}else {
//							perimeter += 1;
//						}
//						
//						if(j>0) {
//							if(arr[i][j-1] == 0) {
//								perimeter += 1;
//							}
//						}else {
//							perimeter += 1;
//						}
//
//						if(i < arr.length-1) {
//							if(arr[i+1][j] == 0) {
//								perimeter += 1;
//							}
//						}else {
//							perimeter += 1;
//						}
//						
//						if(j < arr[0].length-1) {
//							if(arr[i][j+1] == 0) {
//								perimeter += 1;
//							}
//						}else {
//							perimeter += 1;
//						}
//						
//					}
//				}
//			}
//		return perimeter;
//	}
	
	
	
	public static int getPerimeter(int[][] arr) {
	int perimeter = 0;
	
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[0].length; j++) {
			if(arr[i][j] == 1) {
				perimeter += 4;
					
					if(i>0 && arr[i-1][j] == 1) {
						perimeter--;
					}
					
					if(j>0 && arr[i][j-1] == 1) {
						perimeter--;
					}

					if(i < arr.length-1 && arr[i+1][j] == 1) {
						perimeter--;
					}
					
					if(j < arr[0].length-1 && arr[i][j+1] == 1) {
						perimeter--;
					}
					
				}
			}
		}
	return perimeter;
}
	
	

	public static void main(String[] args) {
        int[][] array = {
                {0, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
          		};
        System.out.println(getPerimeter(array) );

	}

}
