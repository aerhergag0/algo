package algorithm.sorts;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, -123, -45};
        System.out.println("정렬 전:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("정렬 후:");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 음수와 양수의 개수를 먼저 계산
        int negCount = 0;
        for (int num : arr) {
            if (num < 0) negCount++;
        }
        int posCount = arr.length - negCount;

        // 배열 한 번만 생성
        int[] negatives = new int[negCount];
        int[] positives = new int[posCount];

        // 한번의 순회로 분리
        int negIndex = 0, posIndex = 0;
        for (int num : arr) {
            if (num < 0) {
                negatives[negIndex++] = -num; // 음수를 양수로 변환
            } else {
                positives[posIndex++] = num;
            }
        }

        // 정렬
        radixSortInternal(negatives);
        radixSortInternal(positives);

        // 결과 병합
        int currentIndex = 0;

        // 음수 값 역순으로 배치
        for (int i = negCount - 1; i >= 0; i--) {
            arr[currentIndex++] = -negatives[i];
        }

        // 양수 값 배치
        for (int i = 0; i < posCount; i++) {
            arr[currentIndex++] = positives[i];
        }
    }

    private static void radixSortInternal(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] output = new int[arr.length];
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp, output);
        }
    }

    private static void countingSort(int[] arr, int exp, int[] output) {
        int[] count = new int[10];

        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
