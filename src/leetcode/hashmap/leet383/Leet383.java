package leetcode.hashmap.leet383;

import java.util.HashMap;

public class Leet383 {
	public boolean canConstruct(String ransomNote, String magazine) {

		HashMap<Character, Integer> magazineMap = new HashMap<>();

		for (char c : magazine.toCharArray()) {
			int currentCount = magazineMap.getOrDefault(c, 0);
			magazineMap.put(c, currentCount + 1);
		}

		for (char r : ransomNote.toCharArray()) {
			if (!magazineMap.containsKey(r) || magazineMap.getOrDefault(r, 0) == 0) {
				return false;
			}

			int currentCount = magazineMap.getOrDefault(r, 0);
			magazineMap.put(r, currentCount - 1);
		}

		return true;
	}
}
