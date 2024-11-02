package algorithm.sorts;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1,10,2,6,5,4,7,9,3};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] array) {
		int idx = 0;
		for (int i = 0; i < array.length; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = i; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					idx = j;
				}

			}

			int temp = array[idx];
			array[idx] = array[i];
			array[i] = temp;
		}
	}
}
