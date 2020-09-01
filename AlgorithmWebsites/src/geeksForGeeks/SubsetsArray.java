package geeksForGeeks;

public class SubsetsArray {

	public static void permutations(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j < input.length(); j++) {
				System.out.println(input.substring(i, j + 1));
			}
		}

	}

	public static void main(String[] args) {
		String str = "ABC";
		permutations(str);
	}
}
