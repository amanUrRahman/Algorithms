/*
Author: Aman Ur Rahman
Program: RotateArray
Description:
Rotate the array in the left direction by the number of elements mentioned as d
*/
package hackerRank;

public class RotateArray {

	static int[] rotLeft(int[] a, int d) {

		int temp[] = new int[d], i, j = 0;
		for (i = 0; i < d; i++) {
			temp[i] = a[i];
		}
		while (i < a.length) {
			a[j] = a[i];
			i++;
			j++;
		}
		i = 0;
		while (j < a.length) {
			a[j] = temp[i];
			j++;
			i++;
		}
		// System.out.println(s);
		return a;

	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		// rotLeft(a,4);
		a = (rotLeft(a, 16));
		for (int i : a)
			System.out.print(i + " ");

	}

}