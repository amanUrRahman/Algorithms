package geeksForGeeks;

public class SubsetsArrayRecursion {

	private static void subsets(String input, String output) {

		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String output1 = output;
		String output2 = output + input.charAt(0);
		input = input.substring(1);
		subsets(input, output1);
		subsets(input, output2);

	}

	public static void main(String[] args) {
		String test = "aman";
		subsets(test, "");
	}

}
