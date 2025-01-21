import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(houses, mid, C)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPossible(int[] houses, int mid, int C) {
        int currentCnt = 1; // 현재 공유기 수
        int beforeHouse = houses[0]; // 이전 설치 위치

        for (int house : houses) {
            if (house - beforeHouse >= mid) {
                currentCnt++;
                beforeHouse = house;
            }
        }

        return currentCnt >= C;
    }
}