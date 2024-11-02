package algorithm.sorts;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {1,10,2,6,5,4,7,9,3};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < (array.length-1)-i; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
