package leetcode.string.leet345;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet345 {
	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		char[] stringToCharArray = s.toCharArray();

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (left < right && !vowels.contains(stringToCharArray[left])) {
				left++;
			}

			while (right > left && !vowels.contains(stringToCharArray[right])) {
				right--;
			}

			char temp = stringToCharArray[left];
			stringToCharArray[left]  = stringToCharArray[right];
			stringToCharArray[right] = temp;

			left++;
			right--;
		}

		return new String(stringToCharArray);
	}
}
