/*
Author: Aman Ur Rahman
Program: BonAppetit
Description:
Anna and Brian are sharing a meal at a restaurant and they agree to split the bill equally. 
Brian wants to order something that Anna is allergic to though, and they agree that Anna won't 
pay for that item. Brian gets the check and calculates Anna's portion. 
You must determine if his calculation is correct.

For example, assume the bill has the following prices: bill - 2,4,6.
Anna declines to eat item k, which is bill[2] which costs 6.
If Brian calculates the bill correctly, Anna will pay (2+4)/2 = 3.
If he includes the cost of bill[2], he will calculate (2+4+6)/2 = 6.
In the second case, he should refund 3 units to Anna.

bill: an array of integers representing the cost of each item ordered
k: an integer representing the zero-based index of the item Anna doesn't eat
b: the amount of money that Anna contributed to the bill
*/

package hackerRank;

import java.util.Arrays;
import java.util.List;

public class BonAppetit {
	static void bonAppetit(List<Integer> bill, int k, int b) {
		long sharedAmount = (bill.stream().filter(i -> k != bill.indexOf(i)).reduce(0, (sum, e) -> sum + e)) / 2;
		if (Long.valueOf(b) == sharedAmount)
			System.out.println("Bon Appetit");
		else if (Long.valueOf(b) > sharedAmount)
			System.out.println(Long.valueOf(b) - sharedAmount);
		else
			System.out.println(Long.valueOf(b) - sharedAmount);
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 10, 2, 9);
		bonAppetit(list, 1, 12);
	}

}
