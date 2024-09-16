package leetcode.string.leet1768;

public class Leet1768 {
	public String mergeAlternately(String word1, String word2) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
			sb.append(word1.charAt(i)).append(word2.charAt(i));
		}

		if (word1.length() > word2.length()) {
			sb.append(word1.substring(word2.length()));
		} else if (word1.length() < word2.length()) {
			sb.append(word2.substring(word1.length()));
		}

		return sb.toString();
	}
}
