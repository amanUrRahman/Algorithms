/*
Author: Aman Ur Rahman
Program: SumCheck
Description:
Take an array of sorted integer and an integer 'n'. check if the sum of the integer is present
in the array but only 2 integers should be added to check this sum
P.S. This should be optimized and be done in one loop flow 
*/

package interviewQs;

public class SumCheck {

	static int numArray[] = { 2, 3, 5, 13, 15, 20, 23 };

	public static void sumCheck(int sum) {
		int endLocation = -1;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] < sum) {
				continue;
			} else if (numArray[i] == sum || numArray[i] > sum) {
				endLocation = i - 1;
				break;
			}
		}
		for (int i = 0, j = endLocation; i < j;) {
			if (numArray[i] + numArray[j] == sum) {
				System.out.println(
						"Sum is present and the variables used are at locations " + (i + 1) + " and " + (j + 1));
				return;
			} else if (numArray[i] + numArray[j] < sum) {
				i++;
				continue;
			} else if (numArray[i] + numArray[j] > sum) {
				j--;
				continue;
			}
		}
		System.out.println("Sum is not present in the array");
		return;
	}

	public static void main(String[] args) {
		for (int i : numArray)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("The sum to be tested for is: 5");
		sumCheck(10);

	}

}
