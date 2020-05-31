/*
Author: Aman Ur Rahman
Program: BinaryPalindrome
Description:
Take an input 'n' and print whether the number has a binary palindrome.
ex. 5 is 101, which is a palindrome
	6 is 110, which is not a palindrome
*/
package interviewQs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryPalindrome {

	public static void checkForBinaryPalindrome(int number) {
		int i = 0, j = 0;
		List<Integer> bin = new ArrayList<Integer>();
		int temp = number;
		while (temp != 0) {
			bin.add(temp % 2);
			temp = temp / 2;
		}
		Collections.reverse(bin);
		System.out.println(bin);
		if (bin.get(bin.size() - 1) == 0 /* || bin.size()%2 == 0 */ ) {
			System.out.println("Number cannot be a binary palindrome");
			return;
		}
		double count1 = 0, count2 = 0;
		int flag = 1;
		for (i = bin.size() - 1; i >= 0; i--) {
			count1 = count1 + 1 * Math.pow(2, i);
			if (flag == 1) {
				flag = 0;
				count2 = count2 + 1 * Math.pow(2, i);
			} else {
				flag = 1;
				count2 = count2 + 0 * Math.pow(2, i);
			}
		}
		int initialFlag = 1;
		for (i = 0, j = bin.size() - 1; i < j; i++, j--) {
			if (bin.get(i).equals(bin.get(j)))
				continue;
			else {
				initialFlag = 0;
				break;
			}
		}
		if (number == count1 || number == count2 || initialFlag == 1) {
			System.out.println("Number is already a Binary Palindrome");
			return;
		} else if (Math.abs(number - count1) > Math.abs(number - count2)) {
			System.out.println((int) Math.abs(number - count2));
		} else if (Math.abs(number - count1) < Math.abs(number - count2)) {
			System.out.println((int) Math.abs(number - count1));
		}
	}

	public static void main(String[] args) {

		checkForBinaryPalindrome(6);

	}

}
