/*
Author: Aman Ur Rahman
Program: LongestRepeatingSubstring
Description:
Print the length of the longest substring with palindrome characters
*/
package leetcode;

public class LongestSubstringPalindrome {

	public static String isLongestPalindrome(String mainString) {
		if (mainString.length() == 0)
			return "";
		StringBuffer palindrome = new StringBuffer();
		String longestPalindrome = "";
		int pointer = 0;
		while (pointer < mainString.length()) {
			if (checkCharacter(palindrome, mainString.charAt(pointer))) {
				palindrome.append(mainString.charAt(pointer));
				longestPalindrome = checkPalindrome(palindrome, mainString.charAt(pointer), longestPalindrome);
			} else {
				palindrome.append(mainString.charAt(pointer));
			}
			pointer++;
		}
		if (longestPalindrome.equals("")) {
			longestPalindrome = String.valueOf(mainString.charAt(0));			
		}
		return longestPalindrome;
	}

	public static String checkPalindrome(StringBuffer palindrome, char check, String longestPalindrome) {
		boolean flag = true;
		for (int i = 0; i < palindrome.length(); i++) {
			if (palindrome.charAt(i) == check) {
				String temp = palindrome.substring(i, palindrome.length());
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) != temp.charAt(temp.length()-1-j)) {
						flag = false;
						break;	
					}
				}	
				if (flag == true) {
					if (palindrome.substring(i, palindrome.length()).length() > longestPalindrome.length()) {
						longestPalindrome = palindrome.substring(i, palindrome.length());
						return longestPalindrome;
					}
				}
			}
			flag = true;
		}
		return longestPalindrome;
	}

	public static boolean checkCharacter(StringBuffer palindrome, char check) {
		boolean present = false;
		for (int i = 0; i < palindrome.length(); i++) {
			if (palindrome.charAt(i) == check) {
				present = true;
				return present;
			} else {
				continue;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		String s = "wojefwerrfeqfqwfnweide";
		System.out.println(isLongestPalindrome(s));
	}

}
