/*
Author: Aman Ur Rahman
Program: ZigzagConversion
Description:
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
*/
package leetcode;

public class ZigzagConversion {

	public static String convert(String s, int numRows) {
		if (numRows == 1 || numRows == 0)
			return s;
		char twoD[][] = new char[numRows][s.length()];
		for (int i = 0; i < twoD.length; i++)
			for (int j = 0; j < twoD[i].length; j++)
				twoD[i][j] = ' ';
		StringBuffer strings[] = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++)
			strings[i] = new StringBuffer();
		StringBuffer finalString = new StringBuffer();
		int pointer = 0, j = 0, i = 0;
		for (i = 0; pointer < s.length();) {
			for (; j < numRows && pointer < s.length(); j++) {
				twoD[j][i] = s.charAt(pointer);
				pointer++;
			}
			j = j - 2;
			while (j >= 1 && pointer < s.length()) {
				i++;
				twoD[j][i] = s.charAt(pointer);
				j--;
				pointer++;
			}
			i++;
		}
		for (int k = 0; k < twoD.length; k++) {
			for (int l = 0; l < twoD[k].length; l++) {
				strings[k].append(twoD[k][l]);
			}
		}
		for (int k = 0; k < numRows; k++) {
			finalString.append(strings[k]);
		}
		return finalString.toString().replace(String.valueOf(' '), "");
	}

	public static void main(String[] args) {
		String zigZagString = convert("PAYPALISHIRING", 13);
		System.out.println(zigZagString);
	}

}
