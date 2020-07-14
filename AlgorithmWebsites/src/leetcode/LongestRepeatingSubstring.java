/*
Author: Aman Ur Rahman
Program: LongestRepeatingSubstring
Description:
Print the length of the longest substring with non-repeating characters
*/
package leetcode;

public class LongestRepeatingSubstring {

	public static int findSubstring(String string) {
		StringBuffer subString = new StringBuffer();
		if (string.length() == 0)
			return 0;
		subString.append(string.charAt(0));
		int pointerToMainString = 1;
		int largestCount = 0;
		while (pointerToMainString < string.length()) {
			if (checkSubString(subString, string.charAt(pointerToMainString))) {
				if (subString.length() > largestCount) {
					largestCount = subString.length();
				}
				subString = pointerBack(subString, string.charAt(pointerToMainString));
				subString.append(string.charAt(pointerToMainString));
			} else {
				subString.append(string.charAt(pointerToMainString));
			}
			pointerToMainString++;
		}
		if (subString.length() > largestCount) {
			largestCount = subString.length();
		}
		return largestCount;
	}

	private static StringBuffer pointerBack(StringBuffer subString, char charAt) {
		int i;
		StringBuffer str = new StringBuffer();
		for (i = subString.length() - 1; i >= 0; i--) {
			if (subString.charAt(i) != charAt) {
				continue;
			}
			break;
		}
		for (i = i + 1; i < subString.length(); i++) {
			str.append(subString.charAt(i));
		}
		return str;
	}

	public static boolean checkSubString(StringBuffer subString, char c) {
		boolean flag = false;
		for (int i = 0; i < subString.length(); i++) {
			if (subString.charAt(i) == c) {
				flag = true;
				return flag;
			} else {
				continue;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int value = findSubstring("abcdabc");
		System.out.println("The longest substring without repeating characters: " + value);

	}

}
