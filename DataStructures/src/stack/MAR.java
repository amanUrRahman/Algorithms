package stack;

public class MAR {

	private static int maximumAreaRectangleInBinaryMatrix(int matrix[][]) {

		int[] array = matrix[0];
		int maxArea = MAH.maximumAreaHistogram(array);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					array[j] = 0;
				} else
					array[j] = array[j] + matrix[i][j];
			}
			maxArea = max(maxArea, MAH.maximumAreaHistogram(array));
		}
		return maxArea;
	}

	public static int max(int first, int second) {
		return first > second ? first : second;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 0, 1, 0, 0 }, 
						   { 1, 1, 1, 1 },
						   { 1, 0, 1, 1 },
						   { 1, 1, 1, 0 } };
		System.out.println(maximumAreaRectangleInBinaryMatrix(matrix));

	}

}
