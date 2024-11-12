package codes.binarysearch.baekjoon7795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ALength = Integer.parseInt(st.nextToken());
            int BLength = Integer.parseInt(st.nextToken());
            int answer = 0;


            int[] A = new int[ALength];
            int[] B = new int[BLength];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < ALength; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < BLength; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            for (int i = 0; i < ALength; i++) {
                answer += binarySearch(B, A[i]);
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int[]arr, int target) {
        int result = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] >= target) {
                right = mid - 1;
            }
        }

        return result + 1;
    }
}
