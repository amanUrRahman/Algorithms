package hackerRank;

import java.util.HashMap;

public class MagicSquares {

	static int formingMagicSquare(int[][] s) {

		HashMap<Integer, Character> m = new HashMap<Integer, Character>();
		int Sum = 0, i;
		for (i = 0; i < s[0].length; i++)
			Sum = Sum + s[0][i];
		System.out.print(Sum);
		for (i = 0; i < s.length; ++i) {
			for (int j = 0; j < s[i].length; ++j) {

				if (m.containsKey(s[i][j])) {

				} else {
					m.put(s[i][j], 'N');
				}

			}
		}

		return 0;

	}

	public static void main(String[] args) {

		String s = "aaa";
		long n = 1000000000;
		long count1 = s.chars().filter(p -> p == 'a').count();
		count1 = count1 * (n / s.length());
		long leftover = n % s.length();
		for (long i = 0; i < leftover; i++) {
			if (s.charAt((int) i) == 'a') {
				count1++;
			}
		}
		System.out.println(count1);

	}

}