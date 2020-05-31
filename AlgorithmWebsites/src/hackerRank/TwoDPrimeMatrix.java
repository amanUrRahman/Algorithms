/*
Author: Aman Ur Rahman
Program: TwoDPrimeMatrix
Description:
The user is given an input of a number 'n'. This number is used to create an n x n matrix 
which contains only prime numbers starting from 2 and going left to right in a row-wise
manner.
Ex. if n = 3, the matrix is as below:

								2	3	5
								7	11	13
								17	19	23
*/
package hackerRank;

public class TwoDPrimeMatrix {
	static int primeCounter = 2;

	public static int getPrime() {
		for (int i = 2; i < primeCounter; i++) {
			if (primeCounter % i == 0) {
				primeCounter++;
				getPrime(); break;
			} else {
				continue;
			}

		}
		return primeCounter;
	}

	public static void twoDMatrixPrimePrint(int n) {
		int twoDMatrix[][] = new int[n][n];
		for (int i = 0; i < twoDMatrix.length; i++) {
			for (int j = 0; j < twoDMatrix.length; j++) {
				System.out.print(getPrime() + "\t");
				primeCounter++;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// int n = 3;
		twoDMatrixPrimePrint(4);
	}

}
