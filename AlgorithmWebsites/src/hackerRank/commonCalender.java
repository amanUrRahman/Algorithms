/*
Author: Aman Ur Rahman
Program: Common Calender
Description:
There are 2 people who want to get into a meeting to discuss career goals but they have meetings thorughout the day. The meetings are of 30 mins each. 

Print all the possible common time frames between the 2 individuals so that they can get into a meeting and continue with their discussion. The meetings can be in any
format
*/

package hackerRank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commonCalender {

	public static List<ArrayList<String>> freeTime(List<List<String>> list) {
		List<ArrayList<String>> freeTime = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).get(1) == list.get(i + 1).get(0))
				continue;
			else {
				int startTime = Integer.parseInt(list.get(i).get(1).replace(":", ""));
				int EndTime = Integer.parseInt(list.get(i + 1).get(0).replace(":", ""));
				for (int j = startTime; j < EndTime;) {
					String freeStartTime = String.valueOf(j);
					String freeEndTime = null;
					if (freeStartTime.substring(2, 4).equals("00")) {
						freeEndTime = freeStartTime.substring(0, 2) + "30";
					} else if (freeStartTime.substring(2, 4).equals("30")) {
						freeEndTime = String.valueOf(Integer.parseInt(freeStartTime.substring(0, 2)) + 1) + "00";
					}
					ArrayList<String> eachTimeSlot = new ArrayList<String>();
					eachTimeSlot.add(freeStartTime.substring(0, 2) + ":" + freeStartTime.substring(2, 4));
					eachTimeSlot.add(freeEndTime.substring(0, 2) + ":" + freeEndTime.substring(2, 4));
					freeTime.add(eachTimeSlot);
					j = Integer.parseInt(freeEndTime);
				}
			}
		}
		return freeTime;
	}

	public static List<ArrayList<String>> commonTime(List<ArrayList<String>> list1, List<ArrayList<String>> list2) {
		List<ArrayList<String>> commonFreeTime = new ArrayList<ArrayList<String>>();

		for (ArrayList<String> l : list1) {
			if (list2.contains(l)) {
				commonFreeTime.add(l);
			}
		}
		return commonFreeTime;
	}

	public static void main(String[] args) {

		List<List<String>> shainaCalender = Arrays.asList(Arrays.asList("10:30", "11:30"), Arrays.asList("12:30", "13:00"), Arrays.asList("15:00", "17:00"));
		List<List<String>> amanCalender = Arrays.asList(Arrays.asList("09:00", "10:00"), Arrays.asList("10:30", "12:00"), Arrays.asList("15:30", "16:30"));

		List<ArrayList<String>> shainaFreeTime = freeTime(shainaCalender);
		List<ArrayList<String>> amanFreeTime = freeTime(amanCalender);
		List<ArrayList<String>> combinedFreeTime = commonTime(shainaFreeTime, amanFreeTime);

		System.out.println(combinedFreeTime);
	}
}




