package geeksForGeeks;

public class SubArrayWithGivenSum {

	private static void subArray(int[] array, int sum) {
		int i, j;
		for (i = 0, j = 0; i < array.length && j < array.length;) {
			if (sum(array, i, j) < sum) {
				j++;
				continue;
			} else if (sum(array, i, j) > sum) {
				i++;
				continue;
			} else if (sum(array, i, j) == sum) {
				System.out.println("The subarray is between indexes " + (i + 1) + " and " + (j + 1));
				return;
			}
		}
		System.out.println("The sum is not present in the array");
	}

	private static int sum(int[] subArray, int i, int j) {
		int sum = 0;
		for (; i <= j; i++) {
			sum = sum + subArray[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		subArray(new int[] { 2, 3, 6, 2, 9, 5, 3 }, 13);

	}

}
