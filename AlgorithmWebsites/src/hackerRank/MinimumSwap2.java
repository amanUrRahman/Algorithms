/*
Author: Aman Ur Rahman
Program: Minimum Swap 2
Description:
You are given an unordered array consisting of consecutive integers in [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements.
You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array  we perform the following steps:

i   arr                     swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took 5 swaps to sort the array.
*/

package hackerRank;

public class MinimumSwap2 {

	public static int minimumSwap(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length;) {

			if (i + 1 == arr[i]) {
				i++;
				continue;
			} else {
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
				count = count + 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int order[] = { 1, 3, 5, 2, 4, 6, 7 };
		System.out.println(minimumSwap(order));
	}
}
