/*
Author: Aman Ur Rahman
Program: Pattern1
Description:
									1	   1
									12	  21
									123  321
									12344321
									123  321
									12	  21
									1	   1
The number of rows can vary
*/

package patternsPrinting;

public class Pattern1 {

	public static void main(String[] args) {
		
		int x = 8;
		for(int i=1; i<=x;i++) {
			for(int j=1; j<=i; j++)
				System.out.print(j + " ");
			for(int j=1; j<=x-i; j++)
				System.out.print("    ");
			for(int j=i; j>=1; j--)
				System.out.print(j + " ");
			System.out.println();
		}
		for(int k=x-1; k>=1;k--) {
			for(int l=1; l<=k; l++)
				System.out.print(l + " ");
			for(int j=k+1; j<=x; j++)
				System.out.print("    ");
			for(int j=k; j>=1; j--)
				System.out.print(j + " ");
			
			System.out.println();
		}
	

	}

}