package algorithm.sorts;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {10, 3, 2, 8, 1, 5, 4, 7, 9, 3};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start >= end) return;

		int pivot = array[(start + end) / 2];
		int pL = start;
		int pR = end;

		while (pL <= pR) {
			while (array[pL] < pivot) {
				pL++;
			}

			while (array[pR] > pivot) {
				pR--;
			}

			if (pL <= pR) {
				swap(array, pL, pR);
				pL++;
				pR--;
			}
		}

		if (start <= pR) {
			quickSort(array, start, pR);
		}

		if (end >= pL) {
			quickSort(array, pL, end);
		}
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
