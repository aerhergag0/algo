package algorithm.sorts;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {10,1,2,8,6,5,4,7,9,3};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int j = i;
			while(array[j] > array[j+1]) {
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
				if (j < 0) break;
			}
		}
	}
}
