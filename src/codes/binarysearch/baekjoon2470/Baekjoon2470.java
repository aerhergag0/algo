package codes.binarysearch.baekjoon2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans1 = 0, ans2 = 0;
        int sum = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            int result = binarySearch(arr, -arr[i], i+1, N-1);

            if (result != -1 && Math.abs(arr[result] + arr[i]) < sum) {
                sum = Math.abs(arr[result] + arr[i]);
                ans1 = arr[i];
                ans2 = arr[result];
            }
        }

        bw.write(ans1 + " " + ans2);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        int result = -1;
        int minDiff = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int diff = Math.abs(arr[mid] - target);

            if (diff < minDiff) {
                minDiff = diff;
                result = mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
