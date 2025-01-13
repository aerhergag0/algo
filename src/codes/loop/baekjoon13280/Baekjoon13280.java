package codes.loop.baekjoon13280;

import java.io.*;

public class Baekjoon13280 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                break;

            int[]    arr    = new int[input];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < input; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            radixSort(arr);

            int minNum = 1000000;
            for (int i = 1; i < input; i++) {
                int x = Math.abs(arr[i] - arr[i - 1]);
                if (minNum > x) {
                    minNum = x;
                }
            }

            bw.write(minNum + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int   n      = arr.length;
        int[] output = new int[n];
        int[] count  = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit    = (arr[i] / exp) % 10;
            int position = count[digit] - 1;
            output[position] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
