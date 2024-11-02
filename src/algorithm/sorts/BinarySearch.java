package algorithm.sorts;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		String[] strings = new String[]{"adam", "bed", "cat", "desk", "egg", "fish", "goat"};
		System.out.println("index : " + binarySearch(strings, "fish"));

		int[] arr = {1,5,99,295,9599};
		System.out.println(Arrays.binarySearch(arr, 0));
	}

	public static int binarySearch(String[] arr, String target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			int comparison = arr[mid].compareTo(target); // 문자열 비교

			if (comparison == 0) {
				return mid; // 목표값을 찾은 경우
			} else if (comparison > 0) {
				right = mid - 1; // 왼쪽 부분으로 좁힘
			} else {
				left = mid + 1;  // 오른쪽 부분으로 좁힘
			}
		}

		return -1; // 값을 찾을 수 없는 경우
	}
}
