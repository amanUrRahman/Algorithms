/*
Author: Aman Ur Rahman
Program: MedianTwoArrays
Description:
To find the median of two sorted arrays
*/
package leetcode;

public class MedianTwoArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double median = 0;
		int maxtraversal = 0, currentTraversal = 0, one = 0, two = 0;
		int previousActive = 0, active = 0;

		if (nums1.length == 1 && nums2.length == 1)
			return (nums1[0] + nums2[0]) / 2;
		if ((nums1.length + nums2.length) % 2 != 0)
			maxtraversal = (nums1.length + nums2.length + 1) / 2;
		else
			maxtraversal = (nums1.length + nums2.length) / 2;

		while (currentTraversal < maxtraversal && one < nums1.length && two < nums2.length) {
			if (active == 0) {
				if (nums1[(one)] < nums2[two]) {
					one++;
					currentTraversal++;
					previousActive = active;
					active = 1;
					continue;
				} else if (nums1[one] > nums2[two]) {
					two++;
					currentTraversal++;
					previousActive = active;
					active = 2;
					continue;
				} else if (nums1[one] == nums2[two]) {
					one++;
					two++;
					currentTraversal = currentTraversal + 2;
					previousActive = active;
					continue;
				}
			}

			if (nums1[(one)] < nums2[two]) {
				one++;
				currentTraversal++;
				previousActive = active;
				active = 1;
				continue;
			} else if (nums1[one] > nums2[two]) {
				two++;
				currentTraversal++;
				previousActive = active;
				active = 2;
				continue;
			} else if (nums1[one] == nums2[two]) {
				one++;
				two++;
				previousActive = active;
				currentTraversal = currentTraversal + 2;
				continue;
			}
		}

		if ((nums1.length + nums2.length) % 2 != 0) {
			if (active == 1) {
				return (double) nums1[one - 1];
			} else if (active == 2) {
				return (double) nums2[two - 1];
			}
		} else {
			if (active == 1 && previousActive == 2) {
				return (double) (nums1[one - 1] + nums2[two]) / 2;
			} else if (active == 2 && previousActive == 1) {
				return (double) (nums2[two - 1] + nums1[one]) / 2;
			} else if (active == 2 && previousActive == 2) {
				return (double) (nums2[two - 1] + nums2[two - 2]) / 2;
			} else if (active == 1 && previousActive == 1) {
				return (double) (nums1[one - 1] + nums1[one - 2]) / 2;
			}
		}

		
		
		
		if (one == nums1.length && currentTraversal != maxtraversal) {
			for (; currentTraversal <= maxtraversal; two++) {
				two++;
				currentTraversal++;
			}
			return (double) nums2[two];
		} else if (two == nums2.length && currentTraversal != maxtraversal) {
			for (; currentTraversal <= maxtraversal; one++) {
				one++;
				currentTraversal++;
			}
			return (double) nums1[one];
		}

		return 0;
	}

	public static void main(String[] args) {

		int nums1[] = { 1, 2, 3, 5, 7, 10, 23 };
		int nums2[] = { 5, 8, 15, 24, 60};

		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

}
