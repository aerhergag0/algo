package codes.hashmap.leet2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet2215 {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> nums1Set = new HashSet<>();
		Set<Integer> nums2Set = new HashSet<>();

		for (int i : nums1) {
			nums1Set.add(i);
		}

		for (int i : nums2) {
			nums2Set.add(i);
		}

		Set<Integer> answer1 = new HashSet<>(nums1Set);
		Set<Integer> answer2 = new HashSet<>(nums2Set);

		for (int i : nums2) {
			answer1.remove(i);
		}

		for (int i : nums1) {
			answer2.remove(i);
		}

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(new ArrayList<>(answer1));
		answer.add(new ArrayList<>(answer2));

		return answer;
	}
}
