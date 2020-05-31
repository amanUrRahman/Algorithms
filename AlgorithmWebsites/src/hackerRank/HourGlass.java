/*
Author: Aman Ur Rahman
Program: HourGlass
Description:
Print the highest hour glass sum
*/
package hackerRank;

public class HourGlass {

	static int hourglassSum(int[][] arr) {

		int sum, greatest = -64, i, j;
		for (i = 0; i + 2 < arr.length; i++) {
			for (j = 0; j + 2 < arr[i].length; j++) {
				sum = 0;
				sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2] + arr[i+1][j+1];
				if (sum > greatest) {
					greatest = sum;
				}		
			}
		}
		return greatest;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { {-1, -1, 0, -9, -2, -2},
									{-2, -1, -6, -8, -2, -5},
									{-1, -1, -1, -2, -3, -4},
									{-1, -9, -2, -4, -4, -5},
									{-7, -3, -3, -2, -9, -9},
									{-1, -3, -1, -2, -4, -5}};
		System.out.println(hourglassSum(arr));
		

	}

}