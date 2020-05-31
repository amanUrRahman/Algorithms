/*
Author: Aman Ur Rahman
Program: Pattern3
Description:
							1	   1
							12	  21
							123	 321
							12344321
									
The number of rows can vary according to the value of n given by the user
*/
package patternsPrinting;

public class Pattern3 {

	public static void main(String[] args) {
		
		int N = 5, j = 0;
		
		for (int i = 1; i <= 5; i++) {
			for (j = 1; j <= i; j++)
				System.out.print(j + " ");
			for (int k = 1; k <= N-i; k++) {
				System.out.print("  ");
				System.out.print("  ");}
			for (j = i; j > 0; j--)
				System.out.print(" " + j);
			System.out.println();			
		}

	}

}