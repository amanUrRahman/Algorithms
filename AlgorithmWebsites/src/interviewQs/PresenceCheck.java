package interviewQs;

import java.util.Arrays;
import java.util.List;

public class PresenceCheck {

	public static void main(String[] args) {
		int i;

		List<String> first = Arrays.asList("HellO", "MumbAI", "HYDerabad");
		List<String> second = Arrays.asList("heLLo", "Kerala", "HYd");

		for (String s : second) {
			if (!first.stream().noneMatch(check -> check.equalsIgnoreCase(s))) {
				System.out.println(s.toUpperCase());
			}
		}

	}
}
