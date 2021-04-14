package hackerRank;

import java.util.HashMap;
import java.util.Map;


public class MakeAnagram {

	static int AnagramCheck(String a, String b) {
		Map<Character, Integer> check = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (check.containsKey(a.charAt(i))) {
				check.put(a.charAt(i), check.get(a.charAt(i)) + 1);
			} else {
				check.put(a.charAt(i), 1);
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (check.containsKey(b.charAt(i))) {
				check.put(b.charAt(i), check.get(b.charAt(i)) - 1);
				if (check.get(b.charAt(i)) == 0) {
					check.remove(b.charAt(i));
				}
			} else {
				count = count + 1;
			}
		}
		for (int i : check.values()) {
			count = count + i;
		}
		return count;
	}

	public static void main(String[] args) {
		String a = "aman";
		String b = "ama";
		System.out.println(AnagramCheck(a, b));

	}

}
