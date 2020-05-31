/*
Author: Aman Ur Rahman
Program: Mimimum Bribe
Description:
It's New Year's Day and everyone's in line for the Wonderland roller coaster ride! There are a number of people queued up, and each person wears a sticker 
indicating their initial position in the queue. Initial positions increment by 1 from 1 at the front of the line to n at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker
denoting their original places in line. One person can bribe at most two others. For example, if n=8 and 5 bribes 4, the queue will look like this:
1,2,3,5,4,6,7,8

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid,
i.e. it requires a person to have bribed more than 2 people.
*/

package hackerRank;

public class NewYearChaos {

	public static void minimumBribe(int order[]) {
		int count = 0;

		for (int i = order.length - 1; i >= 0; i--) {

			if ((order[i] <= i + 1)) {
				continue;
			} else if (order[i] > i + 1 && Math.abs(order[i] - (i + 1)) >= 3) {
				System.out.println("Too chaotic");
				return;
			} else if (order[i] > i + 1 && Math.abs(order[i] - (i + 1)) < 3) {

				if (Math.abs(order[i] - (i + 1)) == 1) {
					int temp = order[i];
					order[i] = order[i + 1];
					order[i + 1] = temp;
					count = count + 1;
					i = i + 1;

				} else if (Math.abs(order[i] - (i + 1)) == 2) {
					int temp = order[i];
					order[i] = order[i + 1];
					order[i + 1] = order[i + 2];
					order[i + 2] = temp;
					count = count + 2;
					i = i + 2;
				}

			}

		}
		
		if (count == 0) {
			System.out.println("There were no bribes given");
			return;
		}
		System.out.println("The mimimum bribes to be given is : " + count);

	}

	public static void main(String[] args) {
		int order[] = {5, 1, 2, 3, 7, 6, 4 };
		minimumBribe(order);
	}

}
