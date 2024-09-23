package leetcode.twopointer.leet392;

public class Leet392 {
	public boolean isSubsequence(String s, String t) {
		int idxS = 0;
		int idxT = 0;

		if (s.length() == 0) {
			return true;
		}

		if (t.length() == 0) {
			return false;
		}

		while (idxT < t.length()) {
			if (s.charAt(idxS) == t.charAt(idxT)) {
				idxS++;

				if (s.length() == idxS) {
					return true;
				}
			}
			idxT++;
		}

		return s.length() == idxS;
	}
}
