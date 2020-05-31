/*
Author: Aman Ur Rahman
Program: LexiArrangement
Description:
Take an array of input and then arrange them according to the dictionary
*/
package interviewQs;

public class LexiArrangement {

	private static void dictionarySet(String[] names) {
		for (int i = 0; i < names.length - 1; i++) {
			for (int j = i + 1; j < names.length; j++) {
				checkToSwitch(names, i, j);
			}
		}
	}

	private static void checkToSwitch(String[] names, int i, int j) {
		for (int a = 0, b = 0; a < names[i].length() && b < names[j].length(); a++, b++) {
			if (names[i].charAt(a) == names[j].charAt(b))
				continue;
			else if (names[i].charAt(a) > names[j].charAt(b)) {
				String temp = names[i];
				names[i] = names[j];
				names[j] = temp;
				return;
			} else
				return;
		}
		return;
	}

	public static void main(String[] args) {
		String[] names = { "Aman", "Amana" };
		dictionarySet(names);
		for (String s : names)
			System.out.println(s + " ");

	}
}
