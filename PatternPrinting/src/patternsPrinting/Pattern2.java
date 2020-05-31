/*
Author: Aman Ur Rahman
Program: Pattern2
Description:
									7654321
									654321
									54321
									4321
									321
									21
									1
									
The number of rows can vary
*/
package patternsPrinting;

public class Pattern2 {

	public static void main(String args[]) {
		
		int x = 7;
		for(int i=0; i<x; i++) {
			for(int j=x-i; j>=1; j--)
				System.out.print(j + " ");
			System.out.println();
		}
	}
}