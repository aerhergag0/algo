package leetcode.string.leet1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> answer = new ArrayList<>();
		int maxCandy = Arrays.stream(candies).max().orElseThrow();
		int goalCandies = maxCandy - extraCandies;

		for (int i : candies) {
			answer.add(goalCandies <= i);
		}

		return answer;
	}
}
