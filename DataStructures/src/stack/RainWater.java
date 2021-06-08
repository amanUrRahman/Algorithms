package stack;

public class RainWater {

	private static int rainWaterTrapping(int height[]) {
		int maxL[] = new int[height.length];
		int maxR[] = new int[height.length];
		int waterTrapping[] = new int[height.length];
		int units = 0;
		maxL[0] = height[0];
		maxR[maxR.length - 1] = height[height.length - 1];
		for (int i = 1; i < height.length; i++) {
			maxL[i] = MAR.max(maxL[i - 1], height[i]);
		}
		for (int j = maxR.length - 2; j >= 0; j--) {
			maxR[j] = MAR.max(maxR[j + 1], height[j]);
		}

		for (int k = 0; k < waterTrapping.length; k++) {
			waterTrapping[k] = min(maxL[k], maxR[k]) - height[k];
			units = units + waterTrapping[k];
		}
		return units;
	}

	private static int min(int first, int second) {
		return first > second ? second : first;
	}

	public static void main(String[] args) {
		int height[] = { 3, 0, 0, 2, 0, 4 };
		System.out.println(rainWaterTrapping(height));

	}

}
