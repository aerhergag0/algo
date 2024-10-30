package codes.hashmap.leet1207;

import java.util.HashMap;
import java.util.HashSet;

public class Leet1207 {
	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i : arr) {
			hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
		}

		HashSet<Integer> hashSet = new HashSet<>();

		for (int i : hashMap.values()) {
			if (hashSet.contains(i)) {
				return false;
			} else {
				hashSet.add(i);
			}
		}

		return true;
	}
}
